package com.github.jakz.generubik.data;

import java.util.Arrays;
import java.util.Random;

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
  
  public Cube dupe()
  {
    Cube cube = new Cube();
    
    for (int i = 0; i < 6; ++i)
      cube.faces[i] = faces[i].dupe();
    
    return cube;
  }
  
  public void reset()
  {
    Color[] colors = new Color[] { Color.WHITE, Color.ORANGE, Color.GREEN, Color.RED, Color.BLUE, Color.YELLOW };
    
    for (int i = 0; i < faces.length; ++i)
      faces[i].reset(i * SIZE * SIZE, colors[i]);
    
    System.out.println(getFace(Side.FRONT));
    getFace(Side.FRONT).flipRow(0);
    System.out.println(getFace(Side.FRONT));
  }
  
  public void shuffle()
  {
    Random r = new Random();
    
    for (int i = 0; i < 256; ++i)
      applyMove(Move.faceRotations[r.nextInt(Move.faceRotations.length)]);
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
  
  public boolean isSolved()
  {
    return Arrays.stream(faces).allMatch(Face::isSolved);        
  }
}
