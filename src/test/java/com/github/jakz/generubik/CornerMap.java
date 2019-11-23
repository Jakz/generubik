package com.github.jakz.generubik;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.github.jakz.generubik.data.Cube;
import com.github.jakz.generubik.data.Face;
import com.github.jakz.generubik.data.Facet;
import com.github.jakz.generubik.data.Side;

public class CornerMap
{
  private class Corner
  {
    private Facet[] facets;
    
    Corner(Facet... facets) 
    { 
      this.facets = facets;
    }
    
    @Override
    public int hashCode()
    {
      return Arrays.hashCode(facets);
    }
    
    @Override
    public boolean equals(Object obj)
    {
      return obj instanceof Corner && Arrays.equals(facets, ((Corner)obj).facets);
    }
    
  }
  
  private final Set<Corner> corners;
  
  public CornerMap(Cube cube)
  {
    corners = new HashSet<>();
    
    Face left = cube.getFace(Side.LEFT);
    Face right = cube.getFace(Side.RIGHT);
    Face up = cube.getFace(Side.UP);
    Face down = cube.getFace(Side.DOWN);
    Face back = cube.getFace(Side.BACK);
    Face front = cube.getFace(Side.FRONT);
    
    /* edges from front */ 
    corners.add(new Corner(front.topLeft(), up.bottomLeft(), left.topRight()));
    corners.add(new Corner(front.top(), up.bottom()));
    corners.add(new Corner(front.topRight(), up.bottomRight(), right.topLeft()));
    corners.add(new Corner(front.right(), right.left()));
    corners.add(new Corner(front.bottomRight(), down.topRight(), right.bottomLeft()));
    corners.add(new Corner(front.bottom(), down.top()));
    corners.add(new Corner(front.bottomLeft(), down.topLeft(), left.bottomRight()));
    corners.add(new Corner(front.left(), left.right()));
    
    /* edges from back */
    
    
  }
}
