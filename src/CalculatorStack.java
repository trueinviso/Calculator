package src;

import java.util.Stack;

public class CalculatorStack {
  private Stack<Float> numbers;

  public CalculatorStack() {
    this.numbers = new Stack<Float>();    
  }
  
  public void pushNumber(float n) {
    this.numbers.push(n);
  }   

  public float add() {
    float secondNum = numbers.pop();
    float firstNum = numbers.pop();
    float result = firstNum + secondNum;
    this.numbers.push(result);
    return result;
  }

  public float multiply() {
    float secondNum = numbers.pop();
    float firstNum = numbers.pop();
    float result = firstNum * secondNum;
    this.numbers.push(result);
    return result;
  }

  public float subtract() {
    float secondNum = numbers.pop();
    float firstNum = numbers.pop();
    float result = firstNum - secondNum;
    this.numbers.push(result);
    return result;
  }

  public float divide() {
    float secondNum = numbers.pop();
    float firstNum = numbers.pop();
    if(secondNum == 0)
      throw new IllegalArgumentException("Divide by 0");
    float result = firstNum / secondNum;
    this.numbers.push(result);
    return result;
  }

  public float cos() {
    float firstNum = numbers.pop(); 
    float result = (float) Math.cos(firstNum);
    this.numbers.push(result);
    return result;
  }
}
