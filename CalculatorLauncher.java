import src.*;

public class CalculatorLauncher {
  public static void main(String[] args) { 
    CalculatorStack stack = new CalculatorStack();
    Validations validate = new Validations();
    CalculatorScanner scanner = new CalculatorScanner();
    Run run = new Run(stack, validate, scanner);
    run.run();
  }
}

