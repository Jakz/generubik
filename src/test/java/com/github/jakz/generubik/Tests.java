package com.github.jakz.generubik;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.jakz.generubik.data.Color;
import com.github.jakz.generubik.data.Cube;
import com.github.jakz.generubik.data.Face;
import com.github.jakz.generubik.data.Facet;

public class Tests
{
  public void sameFaceIsEqualToItself()
  {
    Face face = new Face(Color.BLUE, 0);
    assertEquals(face, face);
  }
  
  public void facesConstructedInSameWayAreEqual()
  {
    assertEquals(new Face(Color.BLUE, 5), new Face(Color.BLUE, 5));
  }
  
  @Test
  public void rotationLeftThanRightProduceSameResult()
  {
    Face face = new Face(Color.YELLOW, 10);
    Face rotated = face.dupe().rotateLeft().rotateRight();
    assertEquals(face, rotated);
  }
  
  @Test
  public void fourLeftRotationsProduceSameResult()
  {
    Face face = new Face(Color.YELLOW, 10);
    Face rotated = face.dupe().rotateLeft().rotateLeft().rotateLeft().rotateLeft();
    assertEquals(face, rotated);
  }
  
  @Test
  public void fourRightRotationsProduceSameResult()
  {
    Face face = new Face(Color.YELLOW, 10);
    Face rotated = face.dupe().rotateRight().rotateRight().rotateRight().rotateRight();
    assertEquals(face, rotated);
  }
  
  @Test
  public void testTwoCornerSetOfSolvedCubeAreEqual()
  {
    Cube cube1 = new Cube(), cube2 = new Cube();
    CornerSet set1 = new CornerSet(cube1), set2 = new CornerSet(cube2);
    assertEquals(set1, set2);
  }
}
