package src;

public class RunCalculator {

  private CalculatorStack stack;
  private Validations validate;
  private CalculatorScanner scanner;
  private String token;

  public RunCalculator(CalculatorStack stack, Validations validate, CalculatorScanner scanner){
    this.stack = stack;
    this.validate = validate;
    this.scanner = scanner;
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
        else {
          System.out.println(stack.calculate(token));
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
      System.err.println(e.getMessage());
      exit();
    }  
  }

  public void exit() {
    scanner.exit();
    System.exit(1);
  }
}
