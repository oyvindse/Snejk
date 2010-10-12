/**The Board class contains all the game physics, and it controls the Gui class
 *
 */



/**
 *
 * @author Andreas Myrhaug, Stian Sorebo and Oyvind Selmer
 */

import java.awt.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import static javax.swing.JOptionPane.*;

public class Board extends JPanel implements ActionListener, KeyListener, Runnable {

    private final int WIDTH = 630;
    private final int HEIGHT = 310;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 900;
    private final int RAND_POS_X = 61;
    private final int RAND_POS_Y = 31;
    private int DELAY = 50;

    private int x[] = new int[ALL_DOTS];
    private int y[] = new int[ALL_DOTS];
    private int x2[] = new int[ALL_DOTS];
    private int y2[] = new int[ALL_DOTS];
    private int wall_x[];
    private int wall_y[];

    private int dots;
    private int dots2;
    private int apple_x;
    private int apple_y;
    private int playersScore;
    private int playersScore2;
    private int applesRemainingCount = 50;
    private int teller = 0;
    private int scoreInc = 18;

    private boolean left = true;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

    private boolean left2 = false;
    private boolean right2 = true;
    private boolean up2 = false;
    private boolean down2 = false;

    private boolean inGame = true;
    private boolean multiplayer = false;
    private boolean p1InGame = false;
    private boolean p2InGame = false;

    private int playerCount = 1;

    public Timer timer;
    private Image ball;
    private Image apple;
    private Image head;
    private Image head2;
    private Image ball2;
    private Image gameOverImage;
    private Image wallImage;
    private Color gameOverColor = Color.BLACK;

    boolean mute = false;
    PlaySound eple;
    PlaySound musikk;
    PlaySound gameOverLyd;
    SplashScreen gameOverSplash;
    HighScoreHandler highScore = new HighScoreHandler();
    HighScore[] highScoreTable;
    Levels levels = new Levels();


    Gui gui;

    JLabel curScore;
    JLabel curScore2;
    JLabel applesRemaining;

    public Board()throws IOException, Exception {
        gui = new Gui(this);
        gui.setVisible(true);

        addKeyListener(new TAdapter());
        Color color = new Color(204,204,255);
        setBackground(color);
        ImageIcon iid = new ImageIcon(this.getClass().getResource("gfx/dot.png"));
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon(this.getClass().getResource("gfx/apple.png"));
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon(this.getClass().getResource("gfx/head.png"));
        head = iih.getImage();

        ImageIcon iih2 = new ImageIcon(this.getClass().getResource("gfx/head2.png"));
        head2 = iih2.getImage();

        ImageIcon iid2 = new ImageIcon(this.getClass().getResource("gfx/dot2.png"));
        ball2 = iid2.getImage();

        ImageIcon goi = new ImageIcon(this.getClass().getResource("gfx/gameoversplash.png"));
        gameOverImage = goi.getImage();

        setFocusable(true);
        try{
            loadHighScores();



         } catch (IOException ex) {
                    Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    /**
     * This is the first method to be called when the player hits "Start"
     * It will it reset the game variables and initialize a new game.
     *
     */
    public void initGame() {

        if(gameOverSplash != null)gameOverSplash.close();
        if(musikk != null && !mute) musikk.stoppLyd();
        if(musikk == null && !mute) musikk = new PlaySound("sounds/music.wav");
        if(mute == false){

        musikk.loopLyd();
        }
        if(multiplayer)p1InGame = true;
        if(multiplayer)p2InGame = true;
        //As default the player1 snake will move from right to left
        left = true;
        right = false;
        up = false;
        down = false;
        if(multiplayer) {
            //As default the player2 snake will move from left to right
            left2 = false;
            right2 = true;
            up2 = false;
            down2 = false;
            //Sets the label for remaining apples in multiplayer mode
            applesRemainingCount = 50;
            gui.lblApples.setText(""+applesRemainingCount);
        }
        if(!multiplayer) {
            playerCount = 1;
            gui.lblApples.setText("");
        }
       //Reset the score variables and the score label
        playersScore = 0;
        playersScore2 = 0;
        gui.lblScore.setText("Green Score: " + playersScore);
        if(multiplayer)gui.lblScore2.setText("Orange Score: " + playersScore2);
        if(!multiplayer)gui.lblScore2.setText("");
        //Default length of the snakes
        dots = 3;
        dots2 = 3;
        teller = 0;
        //Define the start locations at the board
        for (int z = 0; z < dots; z++) {
            x[z] = 580 - z*10;
            y[z] = 50;
        }
        if(multiplayer) {
            for (int h = 0; h < dots2; h++) {
            x2[h] = 50 - h*10;
            y2[h] = 50;
        }

        }
        //Place the first apple
        locateApple();

        //Stop current timer and set speed
        if (timer != null) {
            timer.stop();
            timer.setDelay(DELAY);
            timer.start();
        }
        //Initialize new timer if there's no timer up
        if (timer == null)timer = new Timer(DELAY, this);
       //Restart timer and start the game
        timer.restart();
        inGame = true;

    }
    /**Set a new Delay for the swing Timer
     *
     * @param newDelay
     */
    public void setDelay(int newDelay){
        DELAY = newDelay;
        if(newDelay <= 28)scoreInc = 20;
        else if(newDelay > 28 && newDelay <=48)scoreInc = 18;
        else if(newDelay > 48 && newDelay <= 72)scoreInc = 16;
        else if(newDelay > 72 && newDelay <= 96)scoreInc = 14;
        else scoreInc = 12;
    }

    /**Changes the current soundtrack to specidied *.wav file
     *
     * @param filnavn
     */
    public void byttSang(String filnavn){
        if(musikk != null) musikk.stoppLyd();
        musikk = new PlaySound(filnavn);
        musikk.loopLyd();
    }
    /**Stop Timer
     *
     */
    public void timerStop() {
        timer.stop();
    }
    /**Get Game status
     * @return
     */
    public boolean getGameStatus() {
        return inGame;
    }
    public void loadHighScores() throws IOException, Exception {
        DefaultListModel dlm = new DefaultListModel();
        dlm.clear();

        try {
            highScoreTable = highScore.loadHighScores();
        }catch (IOException ex) {
            //System.out.println("File higscore.ser missing, making new file with default values");
            highScore.highScoreTable();
            highScoreTable = highScore.loadHighScores();
        }
        for(int i=0;i<highScoreTable.length;i++){

             dlm.addElement(highScoreTable[i].getName() +"    "+ highScoreTable[i].getScore());
      }
        gui.HSPanel.setModel(dlm);


    }

    public void checkHighScores()throws IOException, Exception {
        for(int i=0;i<highScoreTable.length;i++){
            if(playersScore >highScoreTable[i].getScore()) {
                String playah = showInputDialog("Congratulations! You made it to Top 3!\n\n Enter your name(max 8letters):");
                if(playah.length() > 12)highScore.newHighScore(playah.substring(0, 8), playersScore); //Name is limited to 12 letters
                else if(playah.length() <= 12)highScore.newHighScore(playah, playersScore);
                break; //Breaking loop so player won't be asked to enter name more than once if better than 3rd place
            }
        }
        highScore.writeHighScores();
        loadHighScores();
    }

    /**This method will be called after DELAY ms to refresh the board components
     *
     * @param g
     */
    public void paint(Graphics g) {
        super.paint(g);

        if (inGame) {
            //Apple spawned inside the snake, respawn
             for (int z = dots; z > 0; z--) {

              if ((z > 4) && (apple_x == x[z]) && (apple_y == y[z])) {
                  locateApple();
              }
          }
             for (int h = dots; h > 0; h--) {

              if ((h > 4) && (apple_x == x2[h]) && (apple_y == y2[h])) {
                  locateApple();
                }
          }
            g.drawImage(apple, apple_x, apple_y, this);

            if(playerCount == 1) {
            for (int z = 0; z < dots; z++) {
                if (z == 0)
                    g.drawImage(head, x[z], y[z], this);
                else g.drawImage(ball, x[z], y[z], this);
            }}
             //multi
            if(multiplayer && playerCount != 1) {
                for (int h = 0; h < dots2; h++) {
                if (h == 0)
                    g.drawImage(head2, x2[h], y2[h], this);
                else g.drawImage(ball2, x2[h], y2[h], this);
            }

            }
            if(playerCount != 1) {
            for (int z = 0; z < dots; z++) {
                if (z == 0)
                    g.drawImage(head, x[z], y[z], this);
                else g.drawImage(ball, x[z], y[z], this);

            }}

            if(multiplayer && playerCount == 1) {
                for (int h = 0; h < dots2; h++) {
                if (h == 0)
                    g.drawImage(head2, x2[h], y2[h], this);
                else g.drawImage(ball2, x2[h], y2[h], this);
            }

            }
            Toolkit.getDefaultToolkit().sync();
            g.dispose();

        } else if(!inGame && teller == 0) {
            teller = 1;
            if(multiplayer) {
                if(p1InGame == false)gameOverP1(g);
                if(p2InGame == false)gameOverP2(g);
                if(applesRemainingCount == 0) {
                    if(playersScore > playersScore2) gameOverP2(g);
                    if(playersScore < playersScore2) gameOverP1(g);
                    if(playersScore == playersScore2) draw(g);
                }
            }
            if(!multiplayer) {
                try {

                    gameOver(g);
                } catch (IOException ex) {
                    Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**Game over - stop timer and show the game over splash screen
     *
     * @param g
     */
    public void gameOver(Graphics g) throws IOException, Exception {
        gameOverSplash(g);
        timer.stop();

    }
    /**Sets the color of the gameover text while in multiplayer mode
     *
     * @param color
     */
    public void setGameOverColor(Color color) {
        gameOverColor = color;
    }
    public void gameOverSplash(Graphics g) {
        g.drawImage(gameOverImage, ((WIDTH /2)-(463/2)), ((HEIGHT/2)-(294/2)), this);
        gameOverLyd = new PlaySound("sounds/laugh.wav");
        musikk.stoppLyd();
        if(mute == false)gameOverLyd.spillLyd();
        timer.stop();
    }

    /**Called when player 2 wins the game
     *
     * @param g
     */
    public void gameOverP1(Graphics g) {
        String msg = "Orange wins with "+ playersScore2 + " points vs "+ playersScore +" points";
        Font large = new Font("Helvetica", Font.BOLD, 24);
        FontMetrics metr = this.getFontMetrics(large);

        g.setColor(gameOverColor);
        g.setFont(large);
        g.drawString(msg, (WIDTH - metr.stringWidth(msg)) / 2,
                     HEIGHT / 2);

        gameOverLyd = new PlaySound("sounds/laugh.wav");
        musikk.stoppLyd();
        if(mute == false)gameOverLyd.spillLyd();
        timer.stop();
        }
    /**Called when player 1 wins the game
     *
     * @param g
     */
    public void gameOverP2(Graphics g) {
            String msg = "Green wins with "+ playersScore + " points vs "+ playersScore2 +" points";
        Font large = new Font("Helvetica", Font.BOLD, 24);
        FontMetrics metr = this.getFontMetrics(large);

        g.setColor(gameOverColor);
        g.setFont(large);
        g.drawString(msg, (WIDTH - metr.stringWidth(msg)) / 2,
                     HEIGHT / 2);

        gameOverLyd = new PlaySound("sounds/laugh.wav");
        musikk.stoppLyd();
        if(mute == false)gameOverLyd.spillLyd();
        timer.stop();
        }

    /**Called when the game ends in a draw
     *
     * @param g
     */
    public void draw(Graphics g) {
                String msg = "It's a draw!! With "+ playersScore + " points vs "+ playersScore2 +" points";
        Font large = new Font("Helvetica", Font.BOLD, 24);
        FontMetrics metr = this.getFontMetrics(large);

        g.setColor(Color.black);
        g.setFont(large);
        g.drawString(msg, (WIDTH - metr.stringWidth(msg)) / 2,
                     HEIGHT / 2);

        gameOverLyd = new PlaySound("sounds/laugh.wav");
        musikk.stoppLyd();
        if(mute == false)gameOverLyd.spillLyd();
        timer.stop();
    }

    /**While ingame this method will run to check if a snake picks up an apple
     *
     */
    public void checkApple() {
        eple = new PlaySound("sounds/apple.wav");
        if ((x[0] == apple_x) && (y[0] == apple_y)) {
            playersScore += scoreInc;
            gui.lblScore.setText("Green Score: "+ playersScore);
            dots += 2;
            locateApple();
            if(mute == false){
                eple.spillLyd();
            }
            if(multiplayer){
                applesRemainingCount--;
                gui.lblApples.setText(""+applesRemainingCount);
            }
            switch (playerCount) {
                case 1: playerCount = 2; break;
                case 2: playerCount = 1; break;
            }
        }
        if(multiplayer) if (((x2[0] == apple_x) && (y2[0] == apple_y))) {

                playersScore2 += 10;
                gui.lblScore2.setText("Orange Score: " + playersScore2);
                dots2 += 2;
                locateApple();
                if(!mute) eple.spillLyd();
                applesRemainingCount--;
                gui.lblApples.setText(""+applesRemainingCount);
        }
    }
    /**Mute sound
     *
     */
    public void muteSound(){
        if(mute == false){
            mute = true;
        }
    }

    /**Unmute sound
     *
     */
    public void unMuteSound(){
        if(mute == true){
            mute = false;
        }
    }
    /**Stop current soundtrack
     *
     */
    public void muteshit(){
        if(musikk != null) musikk.stoppLyd();
        //eple.stopLyd();
    }
    /**Start new soundtrack
     *
     */
    public void startshit(){
        if(musikk == null) musikk = new PlaySound("sounds/music.wav");
        if(!mute)musikk.loopLyd();
    }


    /**Used to change to multiplayer mode
     *
     * @param multi
     */
    public void setMultiplayer(Boolean multi) {
        if(multi)multiplayer = true;
        else multiplayer = false;

    }
    /**This method tells the snake to move forward
     *
     */
    public void move() {
        //Snake1
        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (left) {
            x[0] -= DOT_SIZE;
        }

        if (right) {
            x[0] += DOT_SIZE;
        }

        if (up) {
             y[0] -= DOT_SIZE;
        }

        if (down) {
          y[0] += DOT_SIZE;
        }

        //Snake2
         if(multiplayer) {
            for (int h = dots2; h > 0; h--) {
                x2[h] = x2[(h - 1)];
                y2[h] = y2[(h - 1)];
            }
            if (left2) {
                x2[0] -= DOT_SIZE;
            }

         if (right2) {
                x2[0] += DOT_SIZE;
            }

         if (up2) {
                 y2[0] -= DOT_SIZE;
            }

            if (down2) {
              y2[0] += DOT_SIZE;

            }
          }
    }

    /**Sees that the snake will collide and die if it crashes with the borders of the window or itself.
     *
     */
    public void checkCollision() throws IOException, Exception {

          for (int z = dots; z > 0; z--) {

              if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                  if(multiplayer)p1InGame = false;
                  inGame = false;
                  if(!multiplayer)checkHighScores();
              }
          }

        if (y[0] > HEIGHT) {
            if(multiplayer)p1InGame = false;
            inGame = false;
            if(!multiplayer)checkHighScores();
        }

        if (y[0] < 0) {
            if(multiplayer)p1InGame = false;
            inGame = false;
            if(!multiplayer)checkHighScores();
        }

        if (x[0] > WIDTH) {
            if(multiplayer)p1InGame = false;
            inGame = false;
            if(!multiplayer)checkHighScores();
        }

        if (x[0] < 0) {
            if(multiplayer)p1InGame = false;
            inGame = false;
            if(!multiplayer)checkHighScores();
        }
    //multi
             for (int z = dots2; z > 0; z--) {

              if ((z > 4) && (x2[0] == x2[z]) && (y2[0] == y2[z])) {
                  if(multiplayer)p2InGame = false;
                  inGame = false;
              }
          }
          if (y2[0] > HEIGHT) {
            if(multiplayer)p2InGame = false;
            if(multiplayer)inGame = false;
        }

        if (y2[0] < 0) {
            if(multiplayer)p2InGame = false;
            if(multiplayer)inGame = false;
        }

        if (x2[0] > WIDTH) {
            if(multiplayer)p2InGame = false;
            if(multiplayer)inGame = false;
        }

        if (x2[0] < 0) {
            if(multiplayer)p2InGame = false;
            if(multiplayer)inGame = false;
        }
        if(multiplayer){
            if(applesRemainingCount == 0) inGame = false;
        }

    }
    /**Adds a new apple to the screen
     *
     */
    public void locateApple() {
          int r = (int) (Math.random() * RAND_POS_X);
        apple_x = ((r * DOT_SIZE));
        r = (int) (Math.random() * RAND_POS_Y);
        apple_y = ((r * DOT_SIZE));

    }
    /**This method will access all methods that are required to be updated every DELAY ms
     *
     * @param eswitch
     *
     */
    public void actionPerformed(ActionEvent e) {

        if (inGame) {
            checkApple();
            try {
                checkCollision();
            } catch (IOException ex) {
                Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
            }
            move();
        }

        repaint();
    }

    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**This class handles the keyboard input
     *
     */
    private class TAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent evt) {

            int key = evt.getKeyCode();
            int key2 = evt.getKeyChar();
            //Snake1 is controlled with the cursor keys
            if ((key == KeyEvent.VK_LEFT) && (!right)) {
                left = true;
                up = false;
                down = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!left)) {
                right = true;
                up = false;
                down = false;
            }

            if ((key == KeyEvent.VK_UP) && (!down)) {
                up = true;
                right = false;
                left = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!up))  {
                down = true;
                right = false;
                left = false;

            }
            //Snake2 is controlled with the a,s,w and d keys

           if ((key == KeyEvent.VK_A) && (!right2)) {
                left2 = true;
                up2 = false;
                down2 = false;
            }

            if ((key == KeyEvent.VK_D) && (!left2)) {
                right2 = true;
                up2 = false;
                down2 = false;
            }

            if ((key == KeyEvent.VK_W) && (!down2)) {
                up2 = true;
                right2 = false;
                left2 = false;
            }

            if ((key == KeyEvent.VK_S) && (!up2))  {
                down2 = true;
                right2 = false;
                left2 = false;

            }
            //If not ingame, start game when spacebar is pressed
            if((key == KeyEvent.VK_SPACE) && inGame == false){
                initGame();
            }
        }
    }
}
