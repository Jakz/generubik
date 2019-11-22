package com.github.jakz.generubik.data;

public class Move
{
  public final Side side;
  public final boolean ccw;
  
  private Move(Side side, boolean ccw)
  {
    this.side = side;
    this.ccw = ccw;
  }
  
  public static Move of(Side side, boolean ccw)
  {
    return new Move(side, ccw);
  }
  
  public static Move of(Side side)
  {
    return of(side, false);
  }
}
