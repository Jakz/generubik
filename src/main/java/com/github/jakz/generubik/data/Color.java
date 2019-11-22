package com.github.jakz.generubik.data;

public enum Color
{
  RED(java.awt.Color.RED),
  GREEN(java.awt.Color.GREEN),
  YELLOW(java.awt.Color.YELLOW),
  ORANGE(java.awt.Color.ORANGE),
  BLUE(java.awt.Color.BLUE),
  WHITE(java.awt.Color.WHITE)
  ;
  
  private Color(java.awt.Color color) { this.color = color; }
  
  public final java.awt.Color color;
}
