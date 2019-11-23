package com.github.jakz.generubik.ui;

import java.awt.GridLayout;
import java.util.EnumMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.jakz.generubik.data.Cube;
import com.github.jakz.generubik.data.Side;

public class CubePanel extends JPanel
{
  private final EnumMap<Side, FacePanel> panels = new EnumMap<>(Side.class);
  
  public CubePanel(Cube cube, int size)
  {
    for (Side side : Side.values())
      panels.put(side, new FacePanel(cube, side, size));

    this.setLayout(new GridLayout(3, 4));
    
    this.add(new JLabel());
    this.add(panels.get(Side.UP));
    this.add(new JLabel());
    this.add(new JLabel());
    
    this.add(panels.get(Side.LEFT));
    this.add(panels.get(Side.FRONT));
    this.add(panels.get(Side.RIGHT));
    this.add(panels.get(Side.BACK));
    
    this.add(new JLabel());
    this.add(panels.get(Side.DOWN));
    this.add(new JLabel());
    this.add(new JLabel());
  }
  
  public void refresh()
  {
    panels.forEach((s, p) -> p.refresh());
  }
}
