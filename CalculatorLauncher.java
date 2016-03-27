import src.*;

public class CalculatorLauncher {
  public static void main(String[] args) { 

    CalculatorStack stack = new CalculatorStack();
    Validations validate = new Validations();
    CalculatorScanner scanner = new CalculatorScanner();
    CalculatorCommandTable table = new CalculatorCommandTable(stack);
    String token;

    System.out.print("> ");
    token = scanner.getToken();
    System.out.println(token);

    try {
      while(!validate.quit(token)) {
        if (validate.isNumber(token)) {
          stack.pushNumber(Float.parseFloat(token));
        }
        else {
          System.out.println(table.runStackCommand(token));
        }
        System.out.print("> ");
        token = scanner.getToken();
        System.out.println(token);
      }
    }
    catch(java.util.EmptyStackException e) {
      System.err.println("Invalid expression.");
      scanner.exit();
      System.exit(1);
    }  
    catch(java.lang.IllegalArgumentException e) {
      System.err.println(e.getMessage());
      scanner.exit();
      System.exit(1);
    }  
    scanner.exit();
    System.exit(1);
  }
}
