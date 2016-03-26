package src;

public class Validations {

  public boolean isNumber(String str) {
    return str.matches("[-+]?[0-9]*\\.?[0-9]+");           
  }

  public boolean quit(String str) {
    return !("q".indexOf(str) == -1); 
  }
}
