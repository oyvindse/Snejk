/*
 *
 * Type: Java Game; Snejk v1.0
 *
 */


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


/**
 *
 * @author Andreas Myrhaug, Stian Sorebo and Oyvind Selmer
 */
public class Main extends JFrame {


public Main() {

    setTitle("Snejk v1.0");
    setSize(600,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(true);
    setVisible(true);
}

   public static void main(String[] args)throws IOException, Exception {

       java.awt.EventQueue.invokeLater(new Runnable() {
       public void run() {
                try {


                    Board theBoard = new Board();

                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }




        SplashScreen splashScreen = new SplashScreen ("gfx/splash.gif");
        splashScreen.open (3700);
        PlaySound musikk = new PlaySound("sounds/beat.wav");
        musikk.spillLyd();

       }



    });

   }
}
