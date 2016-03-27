package src;

import java.util.HashMap;
import java.util.Map;

interface Command {
  float runCommand();
}

public class CalculatorCommandTable {

  private Map<String, Command> commandTable ;
  private CalculatorStack stack;

  public CalculatorCommandTable(CalculatorStack stack){
    this.stack = stack;
    buildCommandTable(); 
  }

  public float runStackCommand(String command) {
    if(!commandTable.containsKey(command))
      throw new IllegalArgumentException("Illegal calculator function.");
    return commandTable.get(command).runCommand();
  }

  private void buildCommandTable(){
    this.commandTable = new HashMap<String, Command>();

    commandTable.put("+", new Command() {
      public float runCommand() {
        return stack.add();    
      };
    });

    commandTable.put("-", new Command() {
      public float runCommand() {
        return stack.subtract();    
      };
    });

    commandTable.put("*", new Command() {
      public float runCommand() {
        return stack.multiply();    
      };
    });

    commandTable.put("/", new Command() {
      public float runCommand() {
        return stack.divide();    
      };
    });

    commandTable.put("cos", new Command() {
      public float runCommand() {
        return stack.cos();    
      };
    });
  }
}
