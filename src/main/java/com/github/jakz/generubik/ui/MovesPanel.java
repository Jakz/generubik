package com.github.jakz.generubik.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.github.jakz.generubik.data.moves.CubeRotationMove;
import com.github.jakz.generubik.data.moves.Move;

public class MovesPanel extends JPanel
{
  Move[] moves = new Move[] {
      new CubeRotationMove(CubeRotationMove.Axis.X, false),
      new CubeRotationMove(CubeRotationMove.Axis.Y, false),
      new CubeRotationMove(CubeRotationMove.Axis.Z, false),
      new CubeRotationMove(CubeRotationMove.Axis.X, true),
      new CubeRotationMove(CubeRotationMove.Axis.Y, true),
      new CubeRotationMove(CubeRotationMove.Axis.Z, true)
  };
  
  String[] names = new String[] {
      "X", "Y", "Z",
      "X'", "Y'", "Z'",
  };
  
  private final Mediator mediator;
  
  public MovesPanel(Mediator mediator)
  {
    this.mediator = mediator;
    this.setPreferredSize(new Dimension(200, 200));
    
    JPanel buttons = new JPanel();
    buttons.setLayout(new GridLayout(2,3));
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
