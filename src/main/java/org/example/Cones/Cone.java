package org.example.Cones;

public class Cone
{

  private String flavor;
  private boolean waffle;

  public Cone(String f, boolean w)
  {
    waffle = w;
    flavor = f;
  }

  public void setFlavor(String f)
  {
    flavor = f;
  }

  public String getFlavor()
  {
    return flavor;
  }

  public void setWaffle(Boolean w)
  {
    waffle = w;
  }

  public boolean getWaffle()
  {
    return waffle;
  }

  public String toString()
  {
    String s = "";
    if (waffle)
      s += "waffle ";
    s += "cone with " + flavor;
    return s;
  }

}
