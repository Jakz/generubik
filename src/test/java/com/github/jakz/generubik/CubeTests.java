package com.github.jakz.generubik;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.github.jakz.generubik.data.Color;
import com.github.jakz.generubik.data.Cube;
import com.github.jakz.generubik.data.Face;

public class CubeTests
{  
  @Test
  public void twoCornerSetOfSolvedCubeAreEqual()
  {
    Cube cube1 = new Cube(), cube2 = new Cube();
    CornerSet set1 = new CornerSet(cube1), set2 = new CornerSet(cube2);
    assertEquals(set1, set2);
  }
  
  @Test
  public void shufflingTheCubeIsConsistent()
  {
    Cube cube = new Cube();
    CornerSet expected = new CornerSet(cube);
    
    Cube cube2 = cube.dupe();
    cube2.shuffle();
    CornerSet actual = new CornerSet(cube2);
    
    assertEquals(expected, actual);
    assertNotEquals(cube, cube2);
  }
}
