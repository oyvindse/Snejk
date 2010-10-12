/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.*;

/**
 *
 * @author Bertie
 */
public class Levels {
    private int x_, y_;
    public Levels() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
      //get the screen resolution and divide by 2 to center image
        x_ = (screenSize.width)  / 2;
        y_ = (screenSize.height) / 2;

    }

    public int[] level2() {
        int x2 = 250;
        int[]level2Array = new int[10];
       for(int i =0;i< 10;i++) {
           level2Array[i] = x2;
           x2 += 10;
       }return level2Array;
    }

}
