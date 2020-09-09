package com.github.jakz.generubik;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.jakz.generubik.data.Cube;
import com.github.jakz.generubik.data.moves.MoveSet;

public class MoveSetTests
{
  @Test
  public void reverseOfASetIsTheSameSet()
  {
    MoveSet set = MoveSet.generate(20);
    
    assertEquals(set, set.reverse().reverse());
  }
  
  @Test
  public void applicationOfMoveSetProducesSameResult()
  {
    Cube cube1 = new Cube(), cube2 = new Cube();
    MoveSet set = MoveSet.generate(20);
    
    cube1.apply(set);
    cube2.apply(set);
    
    assertEquals(new CornerSet(cube1), new CornerSet(cube2));
  }
  
  @Test
  public void reverseMoveSetRestoresCube()
  {
    Cube cube1 = new Cube(), cube2 = cube1.dupe();
    MoveSet set = MoveSet.generate(20);
    
    cube1.apply(set);
    cube1.apply(set.reverse());
    
    assertEquals(new CornerSet(cube1), new CornerSet(cube2));
  }

}
