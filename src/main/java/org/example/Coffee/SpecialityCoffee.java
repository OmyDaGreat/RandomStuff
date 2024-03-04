package org.example.Coffee;

public class SpecialityCoffee extends Coffee {

  private String flavor = "";

  public SpecialityCoffee() {
    super();
    setFlavor("vanilla");
  }

  public SpecialityCoffee(String size, String type, String flavor) {
    super(size, false, 1, type);
    setFlavor(flavor);
  }

  public SpecialityCoffee(
    String size,
    boolean isSkinny,
    int shots,
    String type,
    String flavor
  ) {
    super(size, isSkinny, shots, type);
    setFlavor(flavor);
  }

  public void setFlavor(String flavor) {
    this.flavor = flavor;
  }

  public String getFlavor() {
    return flavor;
  }

  public String toString() {
    return super.toString() + " with " + flavor;
  }
}
