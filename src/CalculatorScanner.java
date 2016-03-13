package src;

import java.util.Scanner;

public class CalculatorScanner {
  private Scanner reader;
  private String token;
  private CalculatorStack stack;
  private Validations validate;

  public CalculatorScanner(){
    this.reader = new Scanner(System.in);
    this.stack = new CalculatorStack();
    this.validate = new Validations();
  }

  public void run(){
    System.out.print("> ");
    this.token = getToken();
    System.out.println(token);

    while(!validate.quit(token)) {
      if (validate.isNumber(token)) {
        stack.pushNumber(Float.parseFloat(token));
      }
      else if(validate.isValidSymbol(token)) {
        computeValue(token.charAt(0));
      }
      else {
        System.out.println("Invalid Input");
      }
      System.out.print("> ");
      token = getToken();
      System.out.println(token);
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
      System.err.println("Invalid expression.");
      System.exit(1);
    }  
    catch(java.lang.IllegalArgumentException e) {
      System.err.println("Cannot divide by 0");
      System.exit(1);
    }  
  }

  private String getToken(){
    if(reader.hasNext()) {
      return reader.next();
    }
    else {
      System.out.println("EOF");
      System.exit(1);
    }
    return "q";
  }
}
