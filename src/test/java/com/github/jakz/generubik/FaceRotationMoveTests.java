package com.github.jakz.generubik;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.jakz.generubik.data.Cube;
import com.github.jakz.generubik.data.Side;
import com.github.jakz.generubik.data.moves.FaceRotationMove;
import com.github.jakz.generubik.data.moves.Move;

public class FaceRotationMoveTests
{
  private void testFaceRotationConsistency(Side side, boolean ccw)
  {
    Cube cube = new Cube();
    CornerSet expected = new CornerSet(cube);
    
    cube.applyMove(Move.faceRotation(side, ccw));
    CornerSet actual = new CornerSet(cube);
    
    assertEquals(expected, actual);
  }
  
  @Test
  public void testLeftCWConsistency()
  {
    testFaceRotationConsistency(Side.LEFT, false);
  }
  
  @Test
  public void testLeftCCWConsistency()
  {
    testFaceRotationConsistency(Side.LEFT, true);
  }
  
  @Test
  public void testRightCWConsistency()
  {
    testFaceRotationConsistency(Side.RIGHT, false);
  }
  
  @Test
  public void testRightCCWConsistency()
  {
    testFaceRotationConsistency(Side.RIGHT, true);
  }
  
  @Test
  public void testUpCWConsistency()
  {
    testFaceRotationConsistency(Side.UP, false);
  }
  
  @Test
  public void testUpCCWConsistency()
  {
    testFaceRotationConsistency(Side.UP, true);
  }
  
  @Test
  public void testDownCWConsistency()
  {
    testFaceRotationConsistency(Side.DOWN, false);
  }
  
  @Test
  public void testDownCCWConsistency()
  {
    testFaceRotationConsistency(Side.DOWN, true);
  }
  
  @Test
  public void testFrontCWConsistency()
  {
    testFaceRotationConsistency(Side.FRONT, false);
  }
  
  @Test
  public void testFrontCCWConsistency()
  {
    testFaceRotationConsistency(Side.FRONT, true);
  }
  
  @Test
  public void testBackCWConsistency()
  {
    testFaceRotationConsistency(Side.BACK, false);
  }
  
  @Test
  public void testBackCCWConsistency()
  {
    testFaceRotationConsistency(Side.BACK, true);
  }
  
  @Test
  public void reverseRotationsPreserveStatus()
  {
    for (Move move : Move.faceRotations)
    {
      Cube cube1 = new Cube();
      cube1.shuffle();
      Cube cube2 = cube1.dupe();
      
      cube1.applyMove(move);
      cube1.applyMove(move.reverse());
      
      assertEquals(new CornerSet(cube2), new CornerSet(cube1));
    }
  }
}
