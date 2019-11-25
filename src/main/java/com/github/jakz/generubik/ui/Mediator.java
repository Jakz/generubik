package com.github.jakz.generubik.ui;

import java.util.function.Consumer;

import com.github.jakz.generubik.data.Cube;
import com.github.jakz.generubik.data.moves.Move;

public interface Mediator
{
  public void applyMove(Move move);
  public void lambdaOnCube(Consumer<Cube> lambda);
  public Cube cube();
    
  public static Mediator of(final Cube cube, CubePanel cubePanel)
  {
    return new Mediator() 
    {
      @Override
      public void applyMove(Move move)
      {
        cube.applyMove(move);
        cubePanel.refresh();
      }
      
      @Override
      public void lambdaOnCube(Consumer<Cube> lambda)
      {
        lambda.accept(cube);
        cubePanel.refresh();
      }
      
      @Override
      public Cube cube()
      {
        return cube;
      }
    };
  }
}
