package com.github.jakz.generubik.data.moves;

import com.github.jakz.generubik.data.Cube;
import com.github.jakz.generubik.data.Side;

public class FaceRotationMove extends Move
{
  public final Side side;
  
  private FaceRotationMove(Side side, boolean ccw)
  {
    super(ccw);
    this.side = side;
  }
  
  public static FaceRotationMove of(Side side, boolean ccw)
  {
    return new FaceRotationMove(side, ccw);
  }
  
  public static FaceRotationMove of(Side side)
  {
    return of(side, false);
  }

  @Override
  public void apply(Cube cube)
  {

    switch (side)
    {
      case UP:
      case DOWN:
      {
        final int row = side == Side.UP ? Cube.FIRST_ROW : Cube.LAST_ROW;
        cube.rotateFace(side, ccw);
        
        final boolean rccw = side == Side.UP ? this.ccw : !this.ccw;

        if (!rccw)
        {
          cube.swapRow(Side.LEFT, row, Side.FRONT, row);
          cube.swapRow(Side.FRONT, row, Side.RIGHT, row);
          cube.swapRow(Side.RIGHT, row, Side.BACK, row);
        }
        else
        {
          cube.swapRow(Side.RIGHT, row, Side.FRONT, row);
          cube.swapRow(Side.FRONT, row, Side.LEFT, row);
          cube.swapRow(Side.LEFT, row, Side.BACK, row);
        }  
        
        break;
      }
      
      case LEFT:
      case RIGHT:
      {
        cube.rotateFace(side, ccw);
        
        final int col = side == Side.LEFT ? Cube.FIRST_COLUMN : Cube.LAST_COLUMN;
        final int bcol = side == Side.LEFT ? Cube.LAST_COLUMN : Cube.FIRST_COLUMN;

        final boolean rccw = side == Side.LEFT ? this.ccw : !this.ccw;

        if (rccw)
        {
          cube.swapColumn(Side.UP, col, Side.FRONT, col);
          cube.swapColumn(Side.FRONT, col, Side.DOWN, col);
          cube.swapColumn(Side.DOWN, col, Side.BACK, bcol);
          
          cube.getFace(Side.DOWN).flipColumn(col);

        }
        else
        {
          cube.swapColumn(Side.UP, col, Side.BACK, bcol);
          cube.swapColumn(Side.BACK, bcol, Side.DOWN, col);
          cube.swapColumn(Side.DOWN, col, Side.FRONT, col);
          
          cube.getFace(Side.UP).flipColumn(col);
        }
        
        cube.getFace(Side.BACK).flipColumn(bcol);
        
        break;
      }
      
      case FRONT:
      case BACK:
      {
        final boolean rccw = side == Side.FRONT ? this.ccw : !this.ccw;
        
        cube.rotateFace(side, rccw);
        
        final int rowIndex = side == Side.FRONT ? Cube.FIRST_ROW : Cube.LAST_ROW;
        //final int columnIndex = side == Side.FRONT ? Cube.LAST_COLUMN : Cube.LAST;

/*
        if (!ccw)
        {
          cube.swapRowToColumn(Side.UP, index, Side.RIGHT, index);
          cube.swapColumnToRow(Side.LEFT, index, Side.UP, index);
        }
        else
        {
          
        }*/
      }
    }
  }
}
