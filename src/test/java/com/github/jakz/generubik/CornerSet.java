package com.github.jakz.generubik;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.github.jakz.generubik.data.Cube;
import com.github.jakz.generubik.data.Face;
import com.github.jakz.generubik.data.Facet;
import com.github.jakz.generubik.data.Side;

public class CornerSet
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
   
    @Override
    public String toString()
    {
      return Arrays.stream(facets)
          .map(Object::toString)
          .collect(Collectors.joining(" ", "( ", " )"));
    }
  }
  
  private final Set<Corner> corners;
  
  public CornerSet(Cube cube)
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
    corners.add(new Corner(back.topLeft(), up.topRight(), right.topRight()));
    corners.add(new Corner(back.top(), up.top()));
    corners.add(new Corner(back.topRight(), up.topLeft(), left.topLeft()));
    corners.add(new Corner(back.right(), left.left()));
    corners.add(new Corner(back.bottomRight(), down.bottomLeft(), left.bottomLeft()));
    corners.add(new Corner(back.bottom(), down.bottom()));
    corners.add(new Corner(back.bottomLeft(), down.bottomRight(), right.bottomRight()));
    corners.add(new Corner(back.left(), right.right()));
    
    /* missing edges from middle layer */
    corners.add(new Corner(up.left(), left.top()));
    corners.add(new Corner(up.right(), right.top()));
    corners.add(new Corner(down.left(), left.bottom()));
    corners.add(new Corner(down.right(), right.bottom())); 
  }
  
  @Override
  public boolean equals(Object other)
  {
    return other instanceof CornerSet && ((CornerSet)other).corners.equals(corners);
  }
  
  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    
    int i = 0;
    for (Corner corner : corners)
    {
      sb.append(corner).append(" ");
      ++i;
      if (i % 5 == 0)
        sb.append("\n");
    }
    
    return sb.toString();
  }
}
