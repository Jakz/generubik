package com.github.jakz.generubik;

import com.github.jakz.generubik.data.Cube;
import com.github.jakz.generubik.ui.CubePanel;
import com.pixbits.lib.ui.UIUtils;
import com.pixbits.lib.ui.WrapperFrame;

public class App 
{
  public static void main(String[] args)
  {
    WrapperFrame<CubePanel> frame = UIUtils.buildFrame(new CubePanel(new Cube(), 50), "Cube");
    frame.exitOnClose();
    frame.centerOnScreen();
    frame.setVisible(true);
  }
}
