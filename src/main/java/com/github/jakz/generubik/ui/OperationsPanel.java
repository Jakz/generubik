package com.github.jakz.generubik.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.github.jakz.generubik.data.Cube;
import com.github.jakz.generubik.data.Side;
import com.github.jakz.generubik.data.moves.CubeRotationMove;
import com.github.jakz.generubik.data.moves.FaceRotationMove;
import com.github.jakz.generubik.data.moves.Move;

public class OperationsPanel extends JPanel
{ 
  private final Mediator mediator;
  
  private <T extends Move> JPanel buildMovesPanel(String title, int w, int h, T... moves)
  {
    JPanel panel = new JPanel();
    
    panel = new JPanel(new GridLayout(w, h));
    panel.setBorder(BorderFactory.createTitledBorder(title));
    
    for (T move : moves)
    {
      JButton button = new JButton(move.symbol());
      
      button.addActionListener(e -> this.mediator.applyMove(move));
      panel.add(button);
    }
    
    return panel;
  }
    
  public OperationsPanel(Mediator mediator)
  {
    this.mediator = mediator;
    this.setPreferredSize(new Dimension(300, 400));
    
    JPanel faceRotationsPanel = new JPanel();
    faceRotationsPanel.setLayout(new GridLayout(3,4));
    faceRotationsPanel.setBorder(BorderFactory.createTitledBorder("Face Rotations"));
    setLayout(new BorderLayout());
    add(buildMovesPanel("Face Rotations", 3, 4, Move.faceRotations), BorderLayout.CENTER);
    add(buildMovesPanel("Cube Rotations", 1, 6, Move.cubeRotations), BorderLayout.NORTH);

    JPanel actionsPanel = new JPanel();
    
    JButton reset = new JButton("Reset");
    reset.addActionListener(e -> mediator.lambdaOnCube(Cube::reset));
    actionsPanel.add(reset);
    
    JButton shuffle = new JButton("Shuffle");
    shuffle.addActionListener(e -> mediator.lambdaOnCube(Cube::shuffle));
    actionsPanel.add(shuffle);
    
    add(actionsPanel, BorderLayout.SOUTH);
    
  }
}
