package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import src.CalculatorStack;


public class CalculatorStackTest {

  //Addition method
  @Test
  public void testAddTwoPositive() {
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) 5.0);          
    stack.pushNumber((float) 7.0);    
    float result = stack.add();
    assertTrue("7 + 5 = 12", result == (float) 12.0);
  }
  @Test
  public void testAddTwoNegative() {
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) -5.0);            
    stack.pushNumber((float) -7.0);    
    float result = stack.add();
    assertTrue("-7 + -5 = -12", result == (float) -12.0);
  }
  @Test
  public void testAddFirstNegativeSecondPositive() {
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) -5.0);            
    stack.pushNumber((float) 7.0);    
    float result = stack.add();
    assertTrue("-5 + 7 = 2", result == (float) 2.0);
  }
  @Test
  public void testAddFirstPositiveSecondNegative() {
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) 5.0);            
    stack.pushNumber((float) -7.0);    
    float result = stack.add();
    assertTrue("5 + -7 = -2", result == (float) -2.0);
  }
  @Test
  public void testAddTwoPositiveOneNegative() {
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) 3);          
    stack.pushNumber((float) 5);  
    stack.pushNumber((float) -8);
    float result = stack.add();
    result = stack.subtract();
    assertTrue("3 - (-8 + 5) = 6", result == (float) 6);
  }
  @Test(expected = java.util.EmptyStackException.class)
  public void testEmptyStackExceptionForAdd() {
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) 5); 
    stack.add();
  }
  
  //Subtract method
  @Test
  public void testSubtractTwoPositive() {
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) 5.0);          
    stack.pushNumber((float) 7.0);    
    float result = stack.subtract();
    assertTrue("5 - 7 = -2", result == (float) -2.0);
  }
  @Test
  public void testSubtractTwoNegative() {
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) -5.0);            
    stack.pushNumber((float) -7.0);    
    float result = stack.subtract();
    assertTrue("-5 - -7 = 2", result == (float) 2.0);
  }
  @Test
  public void testSubtractFirstNegativeSecondPositive() {
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) -5.0);            
    stack.pushNumber((float) 7.0);    
    float result = stack.subtract();
    assertTrue("-5 - 7 = -12", result == (float) -12.0);
  }
  @Test
  public void testSubtractFirstPositiveSecondNegative() {
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) 5.0);            
    stack.pushNumber((float) -7.0);    
    float result = stack.subtract();
    assertTrue("5 - -7 = 12", result == (float) 12.0);
  }
  @Test
  public void testSubtractFromAdd() {
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) 5);          
    stack.pushNumber((float) 5);  
    stack.pushNumber((float) 8);
    float result = stack.add();
    result = stack.subtract();
    assertTrue("5 - (8 + 5) = -8", result == (float) -8);
  }
  @Test(expected = java.util.EmptyStackException.class)
  public void testEmptyStackExceptionForSubtract(){
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) 5); 
    stack.subtract();
  }
  //Multiply method
  @Test
  public void testMultiplyTwoPositive() {
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) 5.0);          
    stack.pushNumber((float) 7.0);    
    float result = stack.multiply();
    assertTrue("5 * 7 = 35", result == (float) 35);
  }
  @Test
  public void testMultiplyTwoNegative() {
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) -5.0);            
    stack.pushNumber((float) -7.0);    
    float result = stack.multiply();
    assertTrue("-5 * -7 = 35", result == (float) 35);
  }
  @Test
  public void testMultiplyFirstNegativeSecondPositive() {
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) -5.0);            
    stack.pushNumber((float) 7.0);    
    float result = stack.multiply();
    assertTrue("-5 * 7 = -35", result == (float) -35);
  }
  @Test
  public void testMultiplyFirstPositiveSecondNegative() {
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) 5.0);            
    stack.pushNumber((float) -7.0);    
    float result = stack.multiply();
    assertTrue("5 * -7 = -35", result == (float) -35);
  }
  @Test
  public void testMultiplyFromSubtract() {
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) 5);          
    stack.pushNumber((float) 5);  
    stack.pushNumber((float) 8);
    float result = stack.subtract();
    result = stack.multiply();
    assertTrue("5 * (5 - 8) = -15", result == (float) -15);
  }
  @Test(expected = java.util.EmptyStackException.class)
  public void testEmptyStackExceptionForMultiply(){
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) 5); 
    stack.multiply();
  }
  //Divide method
  @Test
  public void testDivideTwoPositive() {
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) 5.0);          
    stack.pushNumber((float) 10.0);    
    float result = stack.divide();
    assertTrue("5 / 10 = .5", result == (float) .5);
  }
  @Test
  public void testDivideTwoNegative() {
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) -5.0);            
    stack.pushNumber((float) -20.0);    
    float result = stack.divide();
    assertTrue("-5 / -20 = .25", result == (float) .25);
  }
  @Test
  public void testDivideFirstNegativeSecondPositive() {
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) -5.0);            
    stack.pushNumber((float) 20.0);    
    float result = stack.divide();
    assertTrue("-5 / 20 = -.25", result == (float) -.25);
  }
  @Test
  public void testDivideFirstPositiveSecondNegative() {
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) 5.0);            
    stack.pushNumber((float) -20.0);    
    float result = stack.divide();
    assertTrue("5 * -20 = -.25", result == (float) -.25);
  }
  @Test
  public void testDivideFromSubtract() {
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) 5);          
    stack.pushNumber((float) 4);  
    stack.pushNumber((float) 2);
    float result = stack.divide();
    result = stack.subtract();
    assertTrue("5 - (4 / 2) = 3", result == (float) 3);
  }
  @Test(expected = java.util.EmptyStackException.class)
  public void testEmptyStackExceptionForDivide(){
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) 5); 
    stack.divide();
  }
  @Test(expected = java.lang.IllegalArgumentException.class)
  public void testIllegalArgumentExceptionForDivide(){
    CalculatorStack stack = new CalculatorStack();    
    stack.pushNumber((float) 5); 
    stack.pushNumber((float) 0);
    stack.divide();
  }
}
