package com.github.jakz.generubik;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.github.jakz.generubik.data.Cube;
import com.github.jakz.generubik.data.moves.CubeRotationMove;

public class CubeRotationMoveTests
{
  @Test
  public void rotationOnYCWPreserveConsistency()
  {
    Cube cube1 = new Cube(), cube2 = new Cube();
    CornerSet base = new CornerSet(cube1);
    
    cube2.applyMove(new CubeRotationMove(CubeRotationMove.Axis.Y, false));
    
    assertEquals(base, new CornerSet(cube2));
    assertNotEquals(cube1, cube2);
  }
  
  @Test
  public void rotationOnYCCWPreserveConsistency()
  {
    Cube cube1 = new Cube(), cube2 = new Cube();
    CornerSet base = new CornerSet(cube1);
    
    cube2.applyMove(new CubeRotationMove(CubeRotationMove.Axis.Y, true));
    
    assertEquals(base, new CornerSet(cube2));
    assertNotEquals(cube1, cube2);
  }
  
  @Test
  public void rotationOnZCWPreserveConsistency()
  {
    Cube cube1 = new Cube(), cube2 = new Cube();
    CornerSet base = new CornerSet(cube1);
    
    cube2.applyMove(new CubeRotationMove(CubeRotationMove.Axis.Z, false));
    
    assertEquals(base, new CornerSet(cube2));
    assertNotEquals(cube1, cube2);
  }
  
  @Test
  public void rotationOnZCCWPreserveConsistency()
  {
    Cube cube1 = new Cube(), cube2 = new Cube();
    CornerSet base = new CornerSet(cube1);
    
    cube2.applyMove(new CubeRotationMove(CubeRotationMove.Axis.Z, true));
    
    assertEquals(base, new CornerSet(cube2));
    assertNotEquals(cube1, cube2);
  }
  
  @Test
  public void rotationOnXCWPreserveConsistency()
  {
    Cube cube1 = new Cube(), cube2 = new Cube();
    CornerSet base = new CornerSet(cube1);
    
    cube2.applyMove(new CubeRotationMove(CubeRotationMove.Axis.X, false));
    
    assertEquals(base, new CornerSet(cube2));
    assertNotEquals(cube1, cube2);
  }
  
  @Test
  public void rotationOnXCCWPreserveConsistency()
  {
    Cube cube1 = new Cube(), cube2 = new Cube();
    CornerSet base = new CornerSet(cube1);
    
    cube2.applyMove(new CubeRotationMove(CubeRotationMove.Axis.X, true));
    
    assertEquals(base, new CornerSet(cube2));
    assertNotEquals(cube1, cube2);
  }
  
}
