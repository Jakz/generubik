package com.github.jakz.generubik.data;

public class Face
{
  private final Facet[][] facets = new Facet[3][3];
  
  void setFacet(int x, int y, Facet facet)
  {
    facets[x][y] = facet;
  }
  
  public Facet get(int x, int y)
  {
    return facets[x][y];
  }
}
