package com.github.jakz.generubik.data;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Face
{
  private Facet[] facets = new Facet[Cube.SIZE*Cube.SIZE];
  
  public Face()
  {
    
  }
  
  private Facet facet(int x, int y)
  {
    return facets[y*Cube.SIZE + x]; 
  }
  
  public Face(Color color, int i)
  {
    reset(i, color);
  }
  
  public void reset(int base, Color color)
  {
    for (int y = 0; y < Cube.SIZE; ++y)
      for (int x = 0; x < Cube.SIZE; ++x)
        setFacet(x, y, new Facet(color, base + y*3 + x));
  }

  void setFacet(int x, int y, Facet facet)
  {
    facets[y*Cube.SIZE + x] = facet;
  }
  
  public Facet get(int x, int y)
  {
    return facet(x, y);
  }
  
  public Facet get(Corner corner)
  {
    switch (corner)
    {
      case TOP_LEFT: return facet(0,0);
      case TOP: return facet(1,0);
      case TOP_RIGHT: return facet(2,0);
      case RIGHT: return facet(2,1);
      case BOTTOM_RIGHT: return facet(2,2);
      case BOTTOM: return facet(1,2);
      case BOTTOM_LEFT: return facet(0,2);
      case LEFT: return facet(0,1);
      case CENTER: return facet(1,1);
      default:
        throw new NullPointerException();
    }
  }
  
  public Face dupe()
  {
    Face face = new Face();
    for (int y = 0; y < 3; ++y)
      for (int x = 0; x < 3; ++x)
        face.facets[Cube.SIZE*y + x] = new Facet(facet(x,y).color(), facet(x,y).id());
    return face;
  }
   
  private void swap(int x1, int y1, int x2, int y2)
  {
    Facet tmp = facet(x1, y1);
    setFacet(x1, y1, facet(x2, y2));
    setFacet(x2, y2, tmp);
  }
  
  public void transpose()
  {    
    for (int y = 0; y < 3; ++y)
    {
      for (int x = 0; x < y; ++x)
      {
        if (y != x)
        {
          swap(x, y, y, x);
        }
      }
    }
  }
  
  private void reverseColumns()
  {
    for (int i = 0; i < 3; ++i)
      swap(0, i,   2, i);
  }
  
  private void reverseRows()
  {
    for (int i = 0; i < 3; ++i)
      swap(i, 0,   i, 2);
  }
  
  public Face rotateRight()
  {
    transpose();
    reverseColumns();
    return this;
  }
  
  public Face rotateLeft()
  {
    transpose();
    reverseRows();
    return this;
  }
  
  public Face flipRow(int i)
  {
    swap(0, i,   2, i);
    return this;
  }
  
  public Face flipColumn(int i)
  {
    swap(i, 0,   i, 2);
    return this;
  }
  
  public boolean isSolved()
  {
    return Arrays.stream(facets).allMatch(facet -> facet.color() == facets[0].color());
  }
  
  /***
   * 
   * @return value in [0.0-1.0] which represents how much solved is this face
   */
  public float fitness()
  {
    EnumMap<Color, Integer> countBy = new EnumMap<>(Color.class);
    
    Arrays.stream(facets).map(Facet::color).forEach(c -> countBy.compute(c, (cc, i) -> i == null ? 0 : ++i));
    
    int max = countBy.values().stream().max(Integer::compare).get();
    return max / (float)facets.length;
  }
  
  public Facet topLeft() { return get(Corner.TOP_LEFT); }
  public Facet top() { return get(Corner.TOP); }
  public Facet topRight() { return get(Corner.TOP_RIGHT); }
  public Facet right() { return get(Corner.RIGHT); }
  public Facet bottomRight() { return get(Corner.BOTTOM_RIGHT); }
  public Facet bottom() { return get(Corner.BOTTOM); }
  public Facet bottomLeft() { return get(Corner.BOTTOM_LEFT); }
  public Facet left() { return get(Corner.LEFT); }
  public Facet center() { return get(Corner.CENTER); }
  
  public boolean equals(Object other)
  {
    return other instanceof Face && Arrays.deepEquals(((Face)other).facets, facets);
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    
    for (int y = 0; y < Cube.SIZE; ++y)
    {
      for (int x = 0; x < Cube.SIZE; ++x)
        sb.append(facet(x,y)).append(" ");
      sb.append("\n");
      
    }
    
    return sb.toString();
  }
}
