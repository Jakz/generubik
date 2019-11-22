package com.github.jakz.generubik.data;

public class Facet
{
  int id;
  Color color;
  
  public Facet(Color color, int id)
  {
    this.color = color;
    this.id = id;
  }
  
  public int id() { return id; }
  public Color color() { return color; }
  
  public boolean equals(Object other)
  {
    if (other instanceof Facet)
    {
      Facet fother = (Facet)other;
      return fother.color == color && fother.id == id;
    }
    else
      return false;
  }
}
