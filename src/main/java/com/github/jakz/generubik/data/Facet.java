package com.github.jakz.generubik.data;

import java.util.Objects;

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
  
  @Override
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
  
  @Override
  public int hashCode()
  {
    return Objects.hash(id, color);
  }
  
  @Override
  public String toString()
  {
    return String.format("%02d%s", id, color.symbol);
  }
}
