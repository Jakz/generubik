package com.github.jakz.generubik.ui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.jakz.generubik.data.Cube;
import com.github.jakz.generubik.data.Side;

public class CubePanel extends JPanel
{
  public CubePanel(Cube cube, int size)
  {
    this.setLayout(new GridLayout(3, 4));
    
    this.add(new JLabel());
    this.add(new FacePanel(cube.getFace(Side.UP), size));
    this.add(new JLabel());
    this.add(new JLabel());
    
    this.add(new FacePanel(cube.getFace(Side.LEFT), size));
    this.add(new FacePanel(cube.getFace(Side.FRONT), size));
    this.add(new FacePanel(cube.getFace(Side.RIGHT), size));
    this.add(new FacePanel(cube.getFace(Side.BACK), size));
    
    this.add(new JLabel());
    this.add(new FacePanel(cube.getFace(Side.DOWN), size));
    this.add(new JLabel());
    this.add(new JLabel());
  }
}
