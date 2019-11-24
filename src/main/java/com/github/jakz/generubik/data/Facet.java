package com.github.jakz.generubik.data;

import java.util.Objects;

public class Facet implements Comparable<Facet>
{
  private final int id;
  private final Color color;
  
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

  @Override
  public int compareTo(Facet o)
  {
    int i = Integer.compare(id, o.id);
    
    if (i != 0)
      return i;
    
    return color.compareTo(o.color);
  }
}
