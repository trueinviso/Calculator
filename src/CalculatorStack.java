package src;

import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

interface Command {
  float runCommand();
}

public class CalculatorStack {
  private Stack<Float> numbers;
  private Map<String, Command> commandTable ;

  public CalculatorStack() {
    this.numbers = new Stack<Float>();    
    buildCommandTable();
  }
  
  public void pushNumber(float n) {
    this.numbers.push(n);
  }   

  public float calculate(String token) {
    if(!commandTable.containsKey(token))
      throw new IllegalArgumentException("Illegal calculator function.");
    return commandTable.get(token).runCommand();
  }

  private float add() {
    float secondNum = numbers.pop();
    float firstNum = numbers.pop();
    float result = firstNum + secondNum;
    this.numbers.push(result);
    return result;
  }

  private float multiply() {
    float secondNum = numbers.pop();
    float firstNum = numbers.pop();
    float result = firstNum * secondNum;
    this.numbers.push(result);
    return result;
  }

  private float subtract() {
    float secondNum = numbers.pop();
    float firstNum = numbers.pop();
    float result = firstNum - secondNum;
    this.numbers.push(result);
    return result;
  }

  private float divide() {
    float secondNum = numbers.pop();
    float firstNum = numbers.pop();
    if(secondNum == 0)
      throw new IllegalArgumentException("Cannot Divide by 0");
    float result = firstNum / secondNum;
    this.numbers.push(result);
    return result;
  }

  private float cos() {
    float firstNum = numbers.pop(); 
    float result = (float) Math.cos(firstNum);
    this.numbers.push(result);
    return result;
  }

  private void buildCommandTable(){
    this.commandTable = new HashMap<String, Command>();

    commandTable.put("+", new Command() {
      public float runCommand() {
        return add();    
      };
    });

    commandTable.put("-", new Command() {
      public float runCommand() {
        return subtract();    
      };
    });

    commandTable.put("*", new Command() {
      public float runCommand() {
        return multiply();    
      };
    });

    commandTable.put("/", new Command() {
      public float runCommand() {
        return divide();    
      };
    });

    commandTable.put("cos", new Command() {
      public float runCommand() {
        return cos();    
      };
    });
  }
}
