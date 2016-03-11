package src;

import java.util.Stack;

public class CalculatorStack {
  private Stack<Float> numbers;
  float firstNum, secondNum;

  public CalculatorStack() {
    this.numbers = new Stack<Float>();    
  }
  
  public void pushNumber(float n) {
    this.numbers.push(n);
  }   

  private void popNumbers() {
    this.secondNum = numbers.pop();
    this.firstNum = numbers.pop();    
  }

  public float add() {
    popNumbers();
    float result = this.firstNum + this.secondNum;
    this.numbers.push(result);
    return result;
  }

  public float multiply() {
    popNumbers();
    float result = this.firstNum * this.secondNum;
    this.numbers.push(result);
    return result;
  }

  public float subtract() {
    popNumbers();
    float result = this.firstNum - this.secondNum;
    this.numbers.push(result);
    return result;
  }

  //need to check for divide by 0
  public float divide() {
    popNumbers();
    if(this.secondNum == 0)
      throw new IllegalArgumentException("Divide by 0");
    float result = this.firstNum / this.secondNum;
    this.numbers.push(result);
    return result;
  }
}
