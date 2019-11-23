package com.github.jakz.generubik.ui;

import com.github.jakz.generubik.data.Cube;
import com.github.jakz.generubik.data.moves.Move;

public interface Mediator
{
  public void applyMove(Move move);
    
  public static Mediator of(Cube cube, CubePanel cubePanel)
  {
    return new Mediator() 
    {
      @Override
      public void applyMove(Move move)
      {
        cube.applyMove(move);
        cubePanel.refresh();
      }
    };
  }
}
