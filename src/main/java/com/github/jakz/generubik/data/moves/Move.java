package com.github.jakz.generubik.data.moves;

import com.github.jakz.generubik.data.Cube;
import com.github.jakz.generubik.data.Side;

public abstract class Move
{
  boolean ccw;
  String symbol;
  
  protected Move(String symbol, boolean ccw)
  {
    this.symbol = symbol;
    this.ccw = ccw;
  }
  
  public String symbol()
  {
    return symbol;
  }
  
  public abstract void apply(Cube cube);
  
  public static Move[] cubeRotations = new Move[] {
    new CubeRotationMove(CubeRotationMove.Axis.X, false, "X"),
    new CubeRotationMove(CubeRotationMove.Axis.X, true, "X'"),
    new CubeRotationMove(CubeRotationMove.Axis.Y, false, "Y"),
    new CubeRotationMove(CubeRotationMove.Axis.Y, true, "Y'"),
    new CubeRotationMove(CubeRotationMove.Axis.Z, false, "Z"),
    new CubeRotationMove(CubeRotationMove.Axis.Z, true, "Z'"),
  };
  
  public static Move[] faceRotations = new Move[] {
    FaceRotationMove.of(Side.UP, false, "U"),
    FaceRotationMove.of(Side.UP, true, "U'"),
    FaceRotationMove.of(Side.DOWN, false, "D"),
    FaceRotationMove.of(Side.DOWN, true, "D'"),
    FaceRotationMove.of(Side.LEFT, false, "L"),
    FaceRotationMove.of(Side.LEFT, true, "L'"),
    FaceRotationMove.of(Side.RIGHT, false, "R"),
    FaceRotationMove.of(Side.RIGHT, true, "R'"),
    FaceRotationMove.of(Side.FRONT, false, "F"),
    FaceRotationMove.of(Side.FRONT, true, "F'"),
    FaceRotationMove.of(Side.BACK, false, "B"),
    FaceRotationMove.of(Side.BACK, true, "B'"),
  };
  
  public static CubeRotationMove cubeRotation(CubeRotationMove.Axis axis, boolean ccw)
  {
    return new CubeRotationMove(axis, ccw, "");
  }
  
  public static FaceRotationMove faceRotation(Side side, boolean ccw)
  {
    //TODO: should search between existing moves
    return FaceRotationMove.of(side, ccw, "");
  }
}
