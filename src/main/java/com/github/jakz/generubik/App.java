package com.github.jakz.generubik;

import com.github.jakz.generubik.data.Cube;
import com.github.jakz.generubik.ui.CubePanel;
import com.github.jakz.generubik.ui.Mediator;
import com.github.jakz.generubik.ui.MovesPanel;
import com.pixbits.lib.ui.UIUtils;
import com.pixbits.lib.ui.WrapperFrame;

public class App 
{
  public static void main(String[] args)
  {
    Cube cube = new Cube();
    
    WrapperFrame<CubePanel> frame = UIUtils.buildFrame(new CubePanel(cube, 50), "Cube");
    frame.exitOnClose();
    frame.centerOnScreen();
    frame.setVisible(true);
    
    WrapperFrame<MovesPanel> moves = UIUtils.buildFrame(new MovesPanel(Mediator.of(cube, frame.panel())), "Moves");
    moves.centerOnScreen();
    moves.setVisible(true);
  }
}
