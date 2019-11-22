package com.github.jakz.generubik.data;

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
    
    System.out.println(faces[0].toString());
    faces[0].rotateLeft();
    System.out.println(faces[0].toString());
  }
  
  public Face getFace(Side side)
  {
    switch (side)
    {
      case FRONT: return faces[2];
      case UP: return faces[0];
      case LEFT: return faces[1];
      case RIGHT: return faces[3];
      case BACK: return faces[4];
      case DOWN: return faces[5];
      default: return faces[2];
    }
  }
}
