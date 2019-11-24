package com.github.jakz.generubik;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.jakz.generubik.data.Color;
import com.github.jakz.generubik.data.Corner;
import com.github.jakz.generubik.data.Face;

public class FaceTests
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
  public void flipRowWorks()
  {
    Face face = new Face(Color.YELLOW, 10);
    Face dupe = face.dupe().flipRow(0);
    
    assertEquals(face.get(Corner.TOP_LEFT), dupe.get(Corner.TOP_RIGHT));
    assertEquals(face.get(Corner.TOP_RIGHT), dupe.get(Corner.TOP_LEFT));
  }
  
  @Test
  public void flipColumnWorks()
  {
    Face face = new Face(Color.YELLOW, 10);
    Face dupe = face.dupe().flipColumn(0);
    
    assertEquals(face.get(Corner.TOP_LEFT), dupe.get(Corner.BOTTOM_LEFT));
    assertEquals(face.get(Corner.BOTTOM_LEFT), dupe.get(Corner.TOP_LEFT));
  }
  
  @Test
  public void flippingRowTwiceProduceSameResult()
  {
    Face face = new Face(Color.YELLOW, 10);
    Face dupe = face.dupe().flipColumn(0).flipColumn(0);
    
    assertEquals(face, dupe);
  }
  
  @Test
  public void flippingColumnTwiceProduceSameResult()
  {
    Face face = new Face(Color.YELLOW, 10);
    Face dupe = face.dupe().flipRow(0).flipRow(0);
    
    assertEquals(face, dupe);
  }
}
