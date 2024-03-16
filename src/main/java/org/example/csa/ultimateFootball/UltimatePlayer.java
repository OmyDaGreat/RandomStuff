package org.example.csa.ultimateFootball;

public class UltimatePlayer extends Person {

  private static int jerseyNumber = 0;
  private String position = "";
  private final int thisNumber;

  public UltimatePlayer(String firstName, String lastName, String position) {
    super(firstName, lastName);
    this.position = position.equals("handler") || position.equals("cutter") ? position : "handler";
    jerseyNumber++;
    thisNumber = jerseyNumber;
  }

  public String getPosition() {
    return position;
  }

  public int throwDisc(int pow) {
    return pow <= 1 ? 4 : (pow > 10 ? 40 : pow * 4);
  }

  public String toString() {
    return (super.toString() + "\n   Jersey #: " + thisNumber + "\n   Position: " + position);
  }
}
