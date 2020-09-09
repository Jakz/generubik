package com.github.jakz.generubik;

import com.github.jakz.generubik.data.Cube;
import com.github.jakz.generubik.data.moves.MoveSet;
import com.github.jakz.generubik.ui.CubePanel;
import com.github.jakz.generubik.ui.Mediator;
import com.github.jakz.generubik.ui.OperationsPanel;
import com.pixbits.lib.ui.UIUtils;
import com.pixbits.lib.ui.WrapperFrame;

public class App 
{
  public static void main(String[] args)
  {
    Cube cube = new Cube();
    
    MoveSet set = MoveSet.generate(30);
    System.out.println(set.toString());
    
    UIUtils.setNimbusLNF();
    
    WrapperFrame<CubePanel> frame = UIUtils.buildFrame(new CubePanel(cube, 50), "Cube");
    frame.exitOnClose();
    frame.centerOnScreen();
    frame.setVisible(true);
    
    WrapperFrame<OperationsPanel> moves = UIUtils.buildFrame(new OperationsPanel(Mediator.of(cube, frame.panel())), "Moves");
    moves.centerOnScreen();
    moves.setVisible(true);
  }
}
