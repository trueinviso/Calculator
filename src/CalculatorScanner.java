package src;

import java.util.Scanner;

public class CalculatorScanner {
  private Scanner reader;
  private String token;

  public CalculatorScanner(){
    this.reader = new Scanner(System.in);
  }

  public void exit(){
    reader.close();
  }

  public String getToken(){
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
