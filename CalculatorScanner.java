import java.util.Scanner;


public class CalculatorScanner {
  Scanner reader;
  String n;
  CalculatorStack stack;
  Validations validate;

  public CalculatorScanner(){
    this.reader = new Scanner(System.in);
    this.stack = new CalculatorStack();
    this.validate = new Validations();
  }

  public void run(){
    System.out.print("> ");
    this.n = getToken();

    while(!validate.quit(n)) {
      if (validate.isNumber(n)) {
        stack.pushNumber(Float.parseFloat(n));
      }
      else if(validate.isValidSymbol(n)) {
        computeValue(n.charAt(0));
      }
      else {
        System.out.println("Invalid Input");
      }
      System.out.print("> ");
      n = getToken();
    }
  }

  public void exit(){
    reader.close();
  }

  private void computeValue(char n){
    try {
      switch(n) {
        case '+': System.out.println(stack.add());
                  break;
        case '-': System.out.println(stack.subtract());
                  break;
        case '*': System.out.println(stack.multiply());
                  break;
        case '/': System.out.println(stack.divide());
                  break;
        default:  System.out.println("No match");
          }  
    }
    catch(java.util.EmptyStackException e) {
      System.out.println("Invalid expression.");
      System.exit(1);
    }  
    catch(java.lang.IllegalArgumentException e) {
      System.out.println("Cannot divide by 0");
      System.exit(1);
    }  
  }
  private String getToken(){
    return reader.next();
  }
}
