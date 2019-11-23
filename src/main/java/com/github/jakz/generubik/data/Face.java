package com.github.jakz.generubik.data;

import java.util.Arrays;

public class Face
{
  private Facet[][] facets = new Facet[3][3];
  
  public Face()
  {
    
  }
  
  public Face(Color color, int i)
  {
    for (int y = 0; y < 3; ++y)
      for (int x = 0; x < 3; ++x)
        facets[y][x] = new Facet(color, i + y*3 + x);
  }

  void setFacet(int x, int y, Facet facet)
  {
    facets[y][x] = facet;
  }
  
  public Facet get(int x, int y)
  {
    return facets[y][x];
  }
  
  public Facet get(Corner corner)
  {
    switch (corner)
    {
      case TOP_LEFT: return facets[0][0];
      case TOP: return facets[0][1];
      case TOP_RIGHT: return facets[0][2];
      case RIGHT: return facets[1][2];
      case BOTTOM_RIGHT: return facets[2][2];
      case BOTTOM: return facets[2][1];
      case BOTTOM_LEFT: return facets[2][0];
      case LEFT: return facets[1][0];
      case CENTER: return facets[1][1];
      default:
        throw new NullPointerException();
    }
  }
  
  public Face dupe()
  {
    Face face = new Face();
    for (int y = 0; y < 3; ++y)
      for (int x = 0; x < 3; ++x)
        face.facets[y][x] = new Facet(facets[y][x].color, facets[y][x].id);
    return face;
  }
   
  private void swap(int x1, int y1, int x2, int y2)
  {
    Facet tmp = facets[x1][y1];
    facets[x1][y1] = facets[x2][y2];
    facets[x2][y2] = tmp;
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
      swap(i, 0,   i, 2);
  }
  
  private void reverseRows()
  {
    for (int i = 0; i < 3; ++i)
      swap(0, i,   2, i);
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
    
    for (int y = 0; y < 3; ++y)
    {
      for (int x = 0; x < 3; ++x)
        sb.append(String.format("%02d%s ", facets[y][x].id, facets[y][x].color().symbol));
      sb.append("\n");
      
    }
    
    return sb.toString();
  }
}
