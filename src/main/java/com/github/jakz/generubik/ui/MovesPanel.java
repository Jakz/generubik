package com.github.jakz.generubik.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.github.jakz.generubik.data.Side;
import com.github.jakz.generubik.data.moves.CubeRotationMove;
import com.github.jakz.generubik.data.moves.FaceRotationMove;
import com.github.jakz.generubik.data.moves.Move;

public class MovesPanel extends JPanel
{
  Move[] moves = new Move[] {
      FaceRotationMove.of(Side.LEFT, false),
      FaceRotationMove.of(Side.LEFT, true),
      
      FaceRotationMove.of(Side.RIGHT, false),
      FaceRotationMove.of(Side.RIGHT, true),
      
      FaceRotationMove.of(Side.UP, false),
      FaceRotationMove.of(Side.UP, true),
      
      FaceRotationMove.of(Side.DOWN, false),
      FaceRotationMove.of(Side.DOWN, true),
      
      FaceRotationMove.of(Side.FRONT, false),
      FaceRotationMove.of(Side.FRONT, true),
      
      FaceRotationMove.of(Side.BACK, false),
      FaceRotationMove.of(Side.BACK, true),
      
      new CubeRotationMove(CubeRotationMove.Axis.X, false),
      new CubeRotationMove(CubeRotationMove.Axis.Y, false),
      new CubeRotationMove(CubeRotationMove.Axis.Z, false),
      new CubeRotationMove(CubeRotationMove.Axis.X, true),
      new CubeRotationMove(CubeRotationMove.Axis.Y, true),
      new CubeRotationMove(CubeRotationMove.Axis.Z, true)
  };
  
  String[] names = new String[] {
      "L", "L'",
      "R", "R'",
      "U", "U'",
      "D", "D'",
      "F", "F'",
      "B", "B'",
      
      "X", "Y", "Z",
      "X'", "Y'", "Z'",
  };
  
  private final Mediator mediator;
  
  public MovesPanel(Mediator mediator)
  {
    this.mediator = mediator;
    this.setPreferredSize(new Dimension(300, 200));
    
    JPanel buttons = new JPanel();
    buttons.setLayout(new GridLayout(8,4));
    buttons.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    this.setLayout(new BorderLayout());
    this.add(buttons);
    
    for (int i = 0; i < moves.length; ++i)
    {
      JButton button = new JButton(names[i]);
      Move move = moves[i];
      
      button.addActionListener(e -> this.mediator.applyMove(move));
      buttons.add(button);
    }
    
  }
}
