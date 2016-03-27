import src.*;

public class CalculatorLauncher {
  public static void main(String[] args) { 
    CalculatorStack stack = new CalculatorStack();
    Validations validate = new Validations();
    CalculatorScanner scanner = new CalculatorScanner();
    RunCalculator run = new RunCalculator(stack, validate, scanner);
    run.run();
  }
}

