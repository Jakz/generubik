package com.github.jakz.generubik.data.moves;

import com.github.jakz.generubik.data.Cube;
import com.github.jakz.generubik.data.Side;

public class FaceRotationMove extends Move
{
  public final Side side;
  
  private FaceRotationMove(Side side, boolean ccw)
  {
    super(ccw);
    this.side = side;
  }
  
  public static FaceRotationMove of(Side side, boolean ccw)
  {
    return new FaceRotationMove(side, ccw);
  }
  
  public static FaceRotationMove of(Side side)
  {
    return of(side, false);
  }

  @Override
  public void apply(Cube cube)
  {
  }
}
