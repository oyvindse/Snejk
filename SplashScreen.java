/*
 * Used to show a splashScreen / Image file for a given amount of ms
 * and open the template in the editor.
 */


/**
 *
 * @author Andreas Myrhaug, Stian Sorebo and Oyvind Selmer
 */




import java.net.URL;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Timer;
import javax.swing.JWindow;



public class SplashScreen extends JWindow
{
  private Image  image_;
  private int    x_, y_, width_, height_;



 /** Load image file
  *
  * @param imageFileName
  */
  public SplashScreen (String imageFileName)
  {
    super (new Frame());

    try {
      Toolkit toolkit = Toolkit.getDefaultToolkit();

      URL imageUrl = getClass().getResource (imageFileName);
      image_ = toolkit.getImage (imageUrl);

      MediaTracker mediaTracker = new MediaTracker (this);
      mediaTracker.addImage (image_, 0);
      mediaTracker.waitForID (0);

      width_  = image_.getWidth (this);
      height_ = image_.getHeight (this);

      Dimension screenSize = toolkit.getScreenSize();
      //get the screen resolution and divide by 2 to center image
      x_ = (screenSize.width  - width_)  / 2;
      y_ = (screenSize.height - height_) / 2;
    }
    catch (Exception exception) {
      exception.printStackTrace();
      image_ = null;
    }
  }

 /**Open the image and use timer to set duration of splash
  *
  * @param nMilliseconds
  */
  public void open (int nMilliseconds)
  {
    if (image_ == null) return;

    Timer timer = new Timer (Integer.MAX_VALUE, new ActionListener() {
        public void actionPerformed (ActionEvent event) {
          ((Timer) event.getSource()).stop();
          close();
        };
      });


    timer.setInitialDelay (nMilliseconds);
    timer.start();

   setBounds (x_, y_, width_, height_);

    setFocusable(true);
    toFront();
    requestFocus();
    setVisible (true);


  }




   /**Close the splash screen.
    *
    */

  public void close()
  {
    setVisible (false);
    dispose();
  }



 /**Paints the splash screen
  *
  * @param graphics
  */
  public void paint (Graphics graphics)
  {
    if (image_ == null) return;
    graphics.drawImage (image_, 0, 0, width_, height_, this);
  }

}
