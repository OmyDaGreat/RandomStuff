package org.example.ultimateFootball;

public class Person {

  private String firstName = "";
  private String lastName = "";

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public int throwDisc(int pow) {
    return pow <= 1 ? 2 : (pow > 10 ? 20 : pow * 2);
  }

  public String toString() {
    return lastName + ", " + firstName;
  }
}
