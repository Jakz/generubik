package com.github.jakz.generubik.data.moves;

import com.github.jakz.generubik.data.Cube;

public abstract class Move
{
  boolean ccw;
  
  protected Move(boolean ccw)
  {
    this.ccw = ccw;
  }
  
  public abstract void apply(Cube cube);
}
