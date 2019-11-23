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
  }
}
