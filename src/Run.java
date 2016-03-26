package src;

import java.util.HashMap;
import java.util.Map;

interface Command {
  void runCommand();
}

public class Run {

  private CalculatorStack stack;
  private Validations validate;
  private CalculatorScanner scanner;
  private String token;
  private Map<String, Command> commandTable;

  public Run(CalculatorStack stack, Validations validate, CalculatorScanner scanner){
    this.stack = stack;
    this.validate = validate;
    this.scanner = scanner;
    buildCommandTable();
  }

  public void run(){
    System.out.print("> ");
    this.token = scanner.getToken();
    System.out.println(token);

    try {
      while(!validate.quit(token)) {
        if (validate.isNumber(token)) {
          stack.pushNumber(Float.parseFloat(token));
        }
        else if(commandTable.containsKey(token)) {
          commandTable.get(token).runCommand();
        }
        else {
          System.out.println("Invalid Input");
          exit();
        }
        System.out.print("> ");
        token = scanner.getToken();
        System.out.println(token);
      }
    }
    catch(java.util.EmptyStackException e) {
      System.err.println("Invalid expression.");
      exit();
    }  
    catch(java.lang.IllegalArgumentException e) {
      System.err.println("Cannot divide by 0");
      exit();
    }  
  }

  public void exit() {
    scanner.exit();
    System.exit(1);
  }

  private void buildCommandTable(){
    this.commandTable = new HashMap<String, Command>();

    commandTable.put("+", new Command() {
      public void runCommand() {
        System.out.println(stack.add());    
      };
    });

    commandTable.put("-", new Command() {
      public void runCommand() {
        System.out.println(stack.subtract());    
      };
    });

    commandTable.put("*", new Command() {
      public void runCommand() {
        System.out.println(stack.multiply());    
      };
    });

    commandTable.put("/", new Command() {
      public void runCommand() {
        System.out.println(stack.divide());    
      };
    });

    commandTable.put("cos", new Command() {
      public void runCommand() {
        System.out.println(stack.cos());    
      };
    });
  }
}
