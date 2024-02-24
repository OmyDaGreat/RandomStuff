package org.example.ultimateFootball;

public class Captain extends UltimatePlayer {
  private final boolean off;
  
  public Captain(String firstName, String lastName, String position, Boolean type) {
    super(firstName, lastName, position);
    this.off = type;
  }
  
  public int throwDisc(int pow) {
    return pow <= 1 ? 5 : (pow > 10 ? 50 : pow*5);
  }
  
  public String toString() {
    return super.toString() + "\n   Captain: " + (off ? "offense" : "defense");
  }
}