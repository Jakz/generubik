package com.github.jakz.generubik.data;

import com.github.jakz.generubik.data.moves.Move;

public class Cube
{
  public static final int SIZE = 3;
  public static final int FIRST_ROW = 0, LAST_ROW = 2;
  public static final int FIRST_COLUMN = 0, LAST_COLUMN = 2;
  
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
  
  public void rotateFaceLeft(Side side)
  {
    getFace(side).rotateLeft();
  }
  
  public void rotateFaceRight(Side side)
  {
    getFace(side).rotateRight();
  }
  
  public void rotateFace(Side side, boolean ccw)
  {
    if (ccw)
      getFace(side).rotateLeft();
    else
      getFace(side).rotateRight();
  }
  
  public void flipFace(Side side)
  {
    getFace(side).rotateRight();
    getFace(side).rotateRight();
  }
  
  public void swapRow(Side from, int i, Side to, int j)
  {
    Face ffrom = getFace(from), fto = getFace(to);
    
    for (int t = 0; t < SIZE; ++t)
    {
      Facet temp = ffrom.get(t, i);
      ffrom.setFacet(t, i, fto.get(t, j));
      fto.setFacet(t, j, temp);
    }
  }
  
  public void swapColumn(Side from, int i, Side to, int j)
  {
    Face ffrom = getFace(from), fto = getFace(to);
    
    for (int t = 0; t < SIZE; ++t)
    {
      Facet temp = ffrom.get(i, t);
      ffrom.setFacet(i, t, fto.get(j, t));
      fto.setFacet(j, t, temp);
    }
  }
  
  public void swapRowToColumn(Side from, int i, Side to, int j)
  {
    Face ffrom = getFace(from), fto = getFace(to);
    
    for (int t = 0; t < SIZE; ++t)
    {
      Facet temp = ffrom.get(t, i);
      ffrom.setFacet(t, i, fto.get(j, t));
      fto.setFacet(j, t, temp);
    }
  }
  
  public void swapColumnToRow(Side from, int i, Side to, int j)
  {
    Face ffrom = getFace(from), fto = getFace(to);
    
    for (int t = 0; t < SIZE; ++t)
    {
      Facet temp = ffrom.get(i, t);
      ffrom.setFacet(i, t, fto.get(t, j));
      fto.setFacet(t, j, temp);
    }
  }

  public void applyMove(Move move)
  {
    move.apply(this);
  }
}
