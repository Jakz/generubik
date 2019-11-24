package com.github.jakz.generubik;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.jakz.generubik.data.Color;
import com.github.jakz.generubik.data.Face;

public class FaceTests
{
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
}
