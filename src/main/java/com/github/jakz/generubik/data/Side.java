package com.github.jakz.generubik.data;

public enum Side
{
  UP("U"),
  LEFT("L"),
  FRONT("F"),  
  RIGHT("R"),
  BACK("B"),
  DOWN("D")
  
  ;
  
  public final String code;
  
  private Side(String code) { this.code = code; }
}
