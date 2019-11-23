package com.github.jakz.generubik.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.github.jakz.generubik.data.Cube;
import com.github.jakz.generubik.data.Face;
import com.github.jakz.generubik.data.Side;

public class FacePanel extends JPanel
{
  private final Cube cube;
  private final Side side;
  
  private JLabel[][] labels;
  
  public FacePanel(Cube cube, Side side, int cellSize)
  {
    this.cube = cube;
    this.side = side;
    
    this.setLayout(new GridLayout(3,3));
    this.setPreferredSize(new Dimension(cellSize*3, cellSize*3));
    this.labels = new JLabel[3][3];
    
    for (int y = 0; y < 3; ++y)
      for (int x = 0; x < 3; ++x)
      {
        labels[y][x] = new JLabel("", SwingConstants.CENTER);
        labels[y][x].setOpaque(true);
        labels[y][x].setForeground(Color.BLACK);
        labels[y][x].setFont(new Font("plain", Font.BOLD, 20));
        labels[y][x].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        this.add(labels[y][x]);
      }
    
    refresh();
  }
  
  void refresh()
  {
    Face face = cube.getFace(side);
    
    for (int y = 0; y < 3; ++y)
      for (int x = 0; x < 3; ++x)
      {
        labels[y][x].setBackground(face.get(x, y).color().color);
        labels[y][x].setText("" + face.get(x, y).id());
      }
  }
  
  
  
}
