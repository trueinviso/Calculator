import java.util.Stack;

class CalculatorStack {
  private Stack<Float> numbers;
  float firstNum, secondNum;

  public CalculatorStack() {
    this.numbers = new Stack<Float>();    
  }
  
  protected void pushNumber(float n) {
    this.numbers.push(n);
  }   

  private void popNumbers() {
    this.secondNum = numbers.pop();
    this.firstNum = numbers.pop();    
  }

  protected float add() {
    popNumbers();
    float result = this.firstNum + this.secondNum;
    this.numbers.push(result);
    return result;
  }

  protected float multiply() {
    popNumbers();
    float result = this.firstNum * this.secondNum;
    this.numbers.push(result);
    return result;
  }

  protected float subtract() {
    popNumbers();
    float result = this.firstNum - this.secondNum;
    this.numbers.push(result);
    return result;
  }

  //need to check for divide by 0
  protected float divide() {
    popNumbers();
    if(this.secondNum == 0)
      throw new IllegalArgumentException("Divide by 0");
    float result = this.firstNum / this.secondNum;
    this.numbers.push(result);
    return result;
  }
}
