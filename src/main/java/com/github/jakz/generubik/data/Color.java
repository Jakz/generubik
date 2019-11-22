package com.github.jakz.generubik.data;

public enum Color
{
  RED(java.awt.Color.RED, "R"),
  GREEN(java.awt.Color.GREEN, "G"),
  YELLOW(java.awt.Color.YELLOW, "Y"),
  ORANGE(java.awt.Color.ORANGE, "O"),
  BLUE(java.awt.Color.BLUE, "B"),
  WHITE(java.awt.Color.WHITE, "W")
  ;
  
  private Color(java.awt.Color color, String symbol) 
  { 
    this.color = color;
    this.symbol = symbol;
  }
  
  public final java.awt.Color color;
  public final String symbol;
}
