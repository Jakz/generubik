package com.github.jakz.generubik.data.moves;

import com.github.jakz.generubik.data.Cube;
import com.github.jakz.generubik.data.Side;

public abstract class Move
{
  boolean ccw;
  
  protected Move(boolean ccw)
  {
    this.ccw = ccw;
  }

  public abstract Move reverse();
  public abstract void apply(Cube cube);
  public abstract String symbol();
  public abstract String encoding();
  
  @Override
  public boolean equals(Object o)
  {
    return o instanceof Move && ((Move)o).encoding().equals(encoding());
  }
  
  public static Move[] cubeRotations = new Move[] {
    new CubeRotationMove(CubeRotationMove.Axis.X, false),
    new CubeRotationMove(CubeRotationMove.Axis.X, true),
    new CubeRotationMove(CubeRotationMove.Axis.Y, false),
    new CubeRotationMove(CubeRotationMove.Axis.Y, true),
    new CubeRotationMove(CubeRotationMove.Axis.Z, false),
    new CubeRotationMove(CubeRotationMove.Axis.Z, true),
  };
  
  public static Move[] faceRotations = new Move[] {
    FaceRotationMove.of(Side.UP, false),
    FaceRotationMove.of(Side.UP, true),
    FaceRotationMove.of(Side.DOWN, false),
    FaceRotationMove.of(Side.DOWN, true),
    FaceRotationMove.of(Side.LEFT, false),
    FaceRotationMove.of(Side.LEFT, true),
    FaceRotationMove.of(Side.RIGHT, false),
    FaceRotationMove.of(Side.RIGHT, true),
    FaceRotationMove.of(Side.FRONT, false),
    FaceRotationMove.of(Side.FRONT, true),
    FaceRotationMove.of(Side.BACK, false),
    FaceRotationMove.of(Side.BACK, true),
  };
  
  public static final Move[] allMoves = new Move[cubeRotations.length + faceRotations.length];
  
  static
  {
    for (int i = 0; i < cubeRotations.length; ++i)
      allMoves[i] = cubeRotations[i];
    
    for (int i = 0; i < faceRotations.length; ++i)
      allMoves[i + cubeRotations.length] = faceRotations[i];
  }
  
  public static CubeRotationMove cubeRotation(CubeRotationMove.Axis axis, boolean ccw)
  {
    return new CubeRotationMove(axis, ccw);
  }
  
  public static FaceRotationMove faceRotation(Side side, boolean ccw)
  {
    //TODO: should search between existing moves
    return FaceRotationMove.of(side, ccw);
  }
}
