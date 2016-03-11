class Validations {

  public boolean isNumber(String str) {
    return str.matches("[-+]?[0-9]*\\.?[0-9]+");           
  }

  public boolean isValidSymbol(String str) {
    return str.matches("[\\+\\*-/]");
  }

  public boolean quit(String str) {
    return !("q".indexOf(str) == -1); 
  }
}
