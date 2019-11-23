package com.github.jakz.generubik.data;

import com.github.jakz.generubik.data.moves.Move;

public class Cube
{
  private Face[] faces = new Face[6];
  
  public Cube()
  {
    for (int i = 0; i < 6; ++i)
      faces[i] = new Face();
    
    reset();
  }
  
  public void reset()
  {
    Color[] colors = new Color[] { Color.WHITE, Color.ORANGE, Color.GREEN, Color.RED, Color.BLUE, Color.YELLOW };
    
    for (int i = 0; i < 6; ++i)
    {
      for (int c = 0; c < 9; ++c)
      {
        faces[i].setFacet(c % 3, c / 3, new Facet(colors[i], i*9 + c));
      }
    }
    
    /*System.out.println(faces[0].toString());
    faces[0].rotateLeft();
    System.out.println(faces[0].toString());
    
    swapFaces(Side.LEFT, Side.RIGHT);*/
  }
  
  public void swapFaces(Side side1, Side side2)
  {
    //TODO: fragile, based on index
    Face tmp = faces[side1.ordinal()];
    faces[side1.ordinal()] = faces[side2.ordinal()];
    faces[side2.ordinal()] = tmp;
  }
    
  public Face getFace(Side side)
  {
    //TODO: fragile, based on index
    return faces[side.ordinal()];
  }
  
  public void applyMove(Move move)
  {
    move.apply(this);
  }
}
