package com.github.jakz.generubik.data;

public enum Corner
{
  TOP_LEFT,
  TOP,
  TOP_RIGHT,
  RIGHT,
  BOTTOM_RIGHT,
  BOTTOM,
  BOTTOM_LEFT,
  LEFT,
  CENTER
  
  ;
  
  public static final Corner[] drawingOrder = new Corner[] {
      Corner.TOP_LEFT, Corner.TOP, Corner.TOP_RIGHT,
      Corner.LEFT, Corner.CENTER, Corner.RIGHT,
      Corner.BOTTOM_LEFT, Corner.BOTTOM, Corner.BOTTOM_RIGHT
  };
}
