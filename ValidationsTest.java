import static org.junit.Assert.*;

import org.junit.Test;


public class ValidationsTest {

//isNumber method
@Test
  public void testIsNumberZero(){
    Validations v = new Validations();
    assertTrue("0 is a number", v.isNumber("0") == true);
  }
  @Test
  public void testIsNumberMultipleDigits(){
    Validations v = new Validations();
    assertTrue("105 is a number", v.isNumber("105") == true);
  }
  @Test
  public void testIsNumberNegative(){
    Validations v = new Validations();
    assertTrue("-1 is a number", v.isNumber("-1") == true);
  }
  @Test
  public void testIsNumberWildcard(){
    Validations v = new Validations();
    assertTrue("* is not a number", v.isNumber("*") == false);
  }
  @Test
  public void testIsNumberC(){
    Validations v = new Validations();
    assertTrue("C is not a number", v.isNumber("C") == false);
  }
  @Test
  public void testIsNumberPlus(){
    Validations v = new Validations();
    assertTrue("+ is not a number", v.isNumber("+") == false);
  }
  @Test
  public void testIsNumberMinus(){
    Validations v = new Validations();
    assertTrue("- is not a number", v.isNumber("-") == false);
  }
  
  //isValidSymbol method
  @Test
  public void testIsValidSymbolDivide(){
    Validations v = new Validations();
    assertTrue("/ is a valid symbol", v.isValidSymbol("/") == true);
  }
  @Test
  public void testIsValidSymbolMultiply(){
    Validations v = new Validations();
    assertTrue("* is a valid symbol", v.isValidSymbol("*") == true);
  }
  @Test
  public void testIsValidSymbolAdd(){
    Validations v = new Validations();
    assertTrue("+ is a valid symbol", v.isValidSymbol("+") == true);
  }
  @Test
  public void testIsValidSymbolSubtract(){
    Validations v = new Validations();
    assertTrue("- is a valid symbol", v.isValidSymbol("-") == true);
  }
  @Test
  public void testIsNotValidSymbolHash(){
    Validations v = new Validations();
    assertTrue("# is not a valid symbol", v.isValidSymbol("#") == false);
  }
  @Test
  public void testIsValidSymbolBang(){
    Validations v = new Validations();
    assertTrue("! is not a valid symbol", v.isValidSymbol("!") == false);
  }
  //quit method
  @Test
  public void testQuitNotQ(){
    Validations v = new Validations();
    assertTrue("5 returns false", v.quit("5") == false);
  }
  @Test
  public void testQuitQ(){
    Validations v = new Validations();
    assertTrue("q returns true", v.quit("q") == true);
  }
}
