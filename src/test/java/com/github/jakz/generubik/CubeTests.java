package com.github.jakz.generubik;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.jakz.generubik.data.Color;
import com.github.jakz.generubik.data.Cube;
import com.github.jakz.generubik.data.Face;

public class CubeTests
{
  @Test
  public void sameFaceIsEqualToItself()
  {
    Face face = new Face(Color.BLUE, 0);
    assertEquals(face, face);
  }

  @Test
  public void facesConstructedInSameWayAreEqual()
  {
    assertEquals(new Face(Color.BLUE, 5), new Face(Color.BLUE, 5));
  }
  
  @Test
  public void testTwoCornerSetOfSolvedCubeAreEqual()
  {
    Cube cube1 = new Cube(), cube2 = new Cube();
    CornerSet set1 = new CornerSet(cube1), set2 = new CornerSet(cube2);
    assertEquals(set1, set2);
  }
}
