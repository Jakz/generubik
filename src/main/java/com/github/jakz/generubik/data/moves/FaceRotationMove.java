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
      {
        cube.rotateFace(Side.FRONT, ccw);

        if (!ccw)
        {
          cube.swapColumnToRow(Side.RIGHT, Cube.FIRST_COLUMN, Side.DOWN, Cube.FIRST_ROW);
          cube.swapColumnToRow(Side.RIGHT, Cube.FIRST_COLUMN, Side.UP, Cube.LAST_ROW);
          cube.swapRowToColumn(Side.UP, Cube.LAST_ROW, Side.LEFT, Cube.LAST_COLUMN);
          cube.getFace(Side.UP).flipRow(Cube.LAST_ROW);
          cube.getFace(Side.DOWN).flipRow(Cube.FIRST_ROW);

        }
        else
        {
          cube.swapColumnToRow(Side.LEFT, Cube.LAST_COLUMN, Side.DOWN, Cube.FIRST_ROW);
          cube.swapColumnToRow(Side.LEFT, Cube.LAST_COLUMN, Side.UP, Cube.LAST_ROW);
          cube.swapRowToColumn(Side.UP, Cube.LAST_ROW, Side.RIGHT, Cube.FIRST_COLUMN);
          cube.getFace(Side.LEFT).flipColumn(Cube.LAST_COLUMN);
          cube.getFace(Side.RIGHT).flipColumn(Cube.FIRST_COLUMN);
        }

        
        break;
      }
      
      case BACK:
      {
        cube.rotateFace(Side.BACK, ccw);

        if (!ccw)
        {
          cube.swapColumnToRow(Side.RIGHT, Cube.LAST_COLUMN, Side.DOWN, Cube.LAST_ROW);
          cube.swapRowToColumn(Side.DOWN, Cube.LAST_ROW, Side.LEFT, Cube.FIRST_COLUMN);
          cube.swapColumnToRow(Side.LEFT, Cube.FIRST_COLUMN, Side.UP, Cube.FIRST_ROW);
          cube.getFace(Side.LEFT).flipColumn(Cube.FIRST_COLUMN);
          cube.getFace(Side.RIGHT).flipColumn(Cube.LAST_COLUMN);
        }
        else
        {
          cube.swapColumnToRow(Side.LEFT, Cube.FIRST_COLUMN, Side.DOWN, Cube.LAST_ROW);
          cube.swapRowToColumn(Side.DOWN, Cube.LAST_ROW, Side.RIGHT, Cube.LAST_COLUMN);
          cube.swapColumnToRow(Side.RIGHT, Cube.LAST_COLUMN, Side.UP, Cube.FIRST_ROW);
          cube.getFace(Side.UP).flipRow(Cube.FIRST_ROW);
          cube.getFace(Side.DOWN).flipRow(Cube.LAST_ROW);
        }
        
        break;
      }
    }
  }
}
