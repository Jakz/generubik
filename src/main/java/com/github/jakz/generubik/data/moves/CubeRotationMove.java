package com.github.jakz.generubik.data.moves;

import com.github.jakz.generubik.data.Cube;
import com.github.jakz.generubik.data.Side;

public class CubeRotationMove extends Move
{
  public enum Axis { X, Y, Z };
  
  public final Axis axis;
  
  public CubeRotationMove(Axis axis, boolean ccw)
  {
    super(ccw);
    this.axis = axis;
  }

  @Override
  public void apply(Cube cube)
  {
    if (axis == Axis.Y && !ccw)
    {
      cube.swapFaces(Side.LEFT, Side.FRONT);
      cube.swapFaces(Side.FRONT, Side.RIGHT);
      cube.swapFaces(Side.RIGHT, Side.BACK);
      
      cube.getFace(Side.UP).rotateRight();
      cube.getFace(Side.DOWN).rotateLeft();
    }
    else if (axis == Axis.Y && ccw)
    {
      cube.swapFaces(Side.RIGHT, Side.FRONT);
      cube.swapFaces(Side.FRONT, Side.LEFT);
      cube.swapFaces(Side.LEFT, Side.BACK);
      
      cube.getFace(Side.UP).rotateLeft();
      cube.getFace(Side.DOWN).rotateRight();
    }
    
    else if (axis == Axis.Z && !ccw)
    {
      cube.swapFaces(Side.DOWN, Side.RIGHT);
      cube.swapFaces(Side.RIGHT, Side.UP);
      cube.swapFaces(Side.UP, Side.LEFT);
      
      cube.rotateFaceRight(Side.UP);
      cube.rotateFaceRight(Side.RIGHT);
      cube.rotateFaceRight(Side.DOWN);
      cube.rotateFaceRight(Side.LEFT);
      
      cube.rotateFaceRight(Side.FRONT);
      cube.rotateFaceLeft(Side.BACK);
    }
    else if (axis == Axis.Z && ccw)
    {
      cube.swapFaces(Side.DOWN, Side.LEFT);
      cube.swapFaces(Side.LEFT, Side.UP);
      cube.swapFaces(Side.UP, Side.RIGHT);
      
      cube.rotateFaceLeft(Side.UP);
      cube.rotateFaceLeft(Side.RIGHT);
      cube.rotateFaceLeft(Side.DOWN);
      cube.rotateFaceLeft(Side.LEFT);
      
      cube.rotateFaceLeft(Side.FRONT);
      cube.rotateFaceRight(Side.BACK);
    }
    
    else if (axis == Axis.X && !ccw)
    {
      cube.swapFaces(Side.UP, Side.FRONT);
      cube.swapFaces(Side.FRONT, Side.DOWN);
      cube.swapFaces(Side.DOWN, Side.BACK);
     
      cube.flipFace(Side.BACK);
      cube.flipFace(Side.DOWN);
      
      cube.rotateFaceRight(Side.RIGHT);
      cube.rotateFaceLeft(Side.LEFT);
    }
    else if (axis == Axis.X && ccw)
    {
      cube.swapFaces(Side.UP, Side.BACK);
      cube.swapFaces(Side.BACK, Side.DOWN);
      cube.swapFaces(Side.DOWN, Side.FRONT);
      
      cube.flipFace(Side.BACK);
      cube.flipFace(Side.UP);
      
      cube.rotateFaceLeft(Side.RIGHT);
      cube.rotateFaceRight(Side.LEFT);
    }
  }
}
