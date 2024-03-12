package org.example.Cones;

public class DoubleCone extends Cone {

  String f451;
  String t = "";

  public DoubleCone(String f, boolean w) {
    this(f, f, w);
  }

  public DoubleCone(String f, String f451, boolean w) {
    super(f, w);
    this.f451 = f451;
  }

  public void setFlavor(String f) {
    super.setFlavor(f);
    f451 = f;
  }

  public void setFlavor(String f, String f451) {
    super.setFlavor(f);
    this.f451 = f451;
  }

  public void addTopping(String t) {
    this.t = t;
  }

  public String toString() {
    return ((getWaffle() ? "double waffle cone " : "double cone ")
        + (super.getFlavor().equals(f451)
            ? "with " + f451 + " x2"
            : "with " + super.getFlavor() + " and " + f451)
        + (!t.equals("") ? " with " + t : ""));
  }
}
