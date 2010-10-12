/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUI.java
 *
 * Created on 01.apr.2009, 12:59:02
 */



/**
 *
 * @author Andreas Myrhaug
 */



import javax.swing.JFrame;
import java.awt.*;

public class Gui extends JFrame {
Color brown = new Color (98, 68,34);
Color grey = new Color(167, 162, 168);
Color grey2 = new Color(120,120,120);
Color yella = new Color(238, 188, 65);
Color black = new Color(0,0,0);
Color white = new Color(255,255,255);
Color navy = new Color (0, 0, 77);
Color natural1 = new Color (204, 204, 255);
Color natural2 = new Color (204, 255, 51);
Color blue = new Color(0, 0, 255);
Color yellow = new Color(230, 255, 0);
Color red = new Color (255, 0, 0);
Color c64blue = new Color(27, 50, 116);
Color c64red = new Color(219, 27, 27);
Color green = new Color(0, 255, 0);

PlaySound test;
Board snake;
int colorIndex = 2;
Color colorArray[] = {brown, navy};
    /** Creates new form GUI */
    public Gui(Board board) {
        snake = board;
        initComponents();



 }
    //Board snake = new Board();

    private boolean gameStatus;
    private SplashScreen controlSplash;
    private About aboutScreen;

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();

      int x_ = (screenSize.width - 647)  / 2;
      int y_ = (screenSize.height - 512) / 2;




    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GMbgroup = new javax.swing.ButtonGroup();
        boardPanel = snake;
        MenuPanel = new javax.swing.JPanel();
        startb = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        HSPanel = new javax.swing.JList();
        GMPanel = new javax.swing.JPanel();
        player1Button = new javax.swing.JRadioButton();
        player2Button = new javax.swing.JRadioButton();
        speedPanel = new javax.swing.JPanel();
        SpeedSlider = new javax.swing.JSlider();
        bannerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pauseb = new javax.swing.JToggleButton();
        muteButton = new javax.swing.JToggleButton();
        lblScore = new javax.swing.JLabel();
        lblScore2 = new javax.swing.JLabel();
        lblApples = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Snejk v1.0");
        setBackground(new java.awt.Color(204, 255, 51));
        setBounds(x_, y_, 640, 484);
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        boardPanel.setBackground(new java.awt.Color(204, 204, 255));
        boardPanel.setFocusCycleRoot(true);
        boardPanel.setPreferredSize(new java.awt.Dimension(610, 300));

        org.jdesktop.layout.GroupLayout boardPanelLayout = new org.jdesktop.layout.GroupLayout(boardPanel);
        boardPanel.setLayout(boardPanelLayout);
        boardPanelLayout.setHorizontalGroup(
            boardPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 640, Short.MAX_VALUE)
        );
        boardPanelLayout.setVerticalGroup(
            boardPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 322, Short.MAX_VALUE)
        );

        MenuPanel.setBackground(new java.awt.Color(204, 255, 51));
        MenuPanel.setFocusable(false);
        MenuPanel.setMaximumSize(new java.awt.Dimension(600, 400));
        MenuPanel.setPreferredSize(new java.awt.Dimension(600, 200));
        MenuPanel.setRequestFocusEnabled(false);

        startb.setBackground(new java.awt.Color(204, 255, 51));
        startb.setText("Start");
        startb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startbActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);

        HSPanel.setBackground(new java.awt.Color(204, 255, 51));
        HSPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "HighScore"));
        HSPanel.setAutoscrolls(false);
        HSPanel.setFocusable(false);
        jScrollPane1.setViewportView(HSPanel);

        GMPanel.setBackground(new java.awt.Color(204, 255, 51));
        GMPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Game Modes"));
        GMPanel.setPreferredSize(new java.awt.Dimension(120, 105));

        player1Button.setBackground(new java.awt.Color(204, 255, 51));
        GMbgroup.add(player1Button);
        player1Button.setSelected(true);
        player1Button.setText("1 Player");
        player1Button.setActionCommand("Free play");
        player1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player1ButtonActionPerformed(evt);
            }
        });

        player2Button.setBackground(new java.awt.Color(204, 255, 51));
        GMbgroup.add(player2Button);
        player2Button.setText("2 Players");
        player2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2ButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout GMPanelLayout = new org.jdesktop.layout.GroupLayout(GMPanel);
        GMPanel.setLayout(GMPanelLayout);
        GMPanelLayout.setHorizontalGroup(
            GMPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(GMPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(GMPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(player1Button)
                    .add(player2Button))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        GMPanelLayout.setVerticalGroup(
            GMPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, GMPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(player1Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(player2Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        speedPanel.setBackground(new java.awt.Color(204, 255, 51));
        speedPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Adjust Speed"));

        SpeedSlider.setBackground(new java.awt.Color(204, 255, 51));
        SpeedSlider.setMaximum(120);
        SpeedSlider.setMinimum(20);
        SpeedSlider.setMinorTickSpacing(25);
        SpeedSlider.setPaintTicks(true);
        SpeedSlider.setSnapToTicks(true);
        SpeedSlider.setToolTipText("Adjust speed and press Start");
        SpeedSlider.setValue(100);
        SpeedSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                SpeedSliderMouseDragged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout speedPanelLayout = new org.jdesktop.layout.GroupLayout(speedPanel);
        speedPanel.setLayout(speedPanelLayout);
        speedPanelLayout.setHorizontalGroup(
            speedPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(SpeedSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 149, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        speedPanelLayout.setVerticalGroup(
            speedPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(SpeedSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        bannerPanel.setBackground(new java.awt.Color(204, 255, 51));
        bannerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bannerPanel.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36));
        jLabel1.setText("SNEJK v1.0");

        org.jdesktop.layout.GroupLayout bannerPanelLayout = new org.jdesktop.layout.GroupLayout(bannerPanel);
        bannerPanel.setLayout(bannerPanelLayout);
        bannerPanelLayout.setHorizontalGroup(
            bannerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(bannerPanelLayout.createSequentialGroup()
                .add(69, 69, 69)
                .add(jLabel1)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        bannerPanelLayout.setVerticalGroup(
            bannerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        pauseb.setBackground(new java.awt.Color(204, 255, 51));
        pauseb.setText("Pause");
        pauseb.setFocusable(false);
        pauseb.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pausebStateChanged(evt);
            }
        });
        pauseb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                pausebItemStateChanged(evt);
            }
        });
        pauseb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausebActionPerformed(evt);
            }
        });

        muteButton.setBackground(new java.awt.Color(204, 255, 51));
        muteButton.setText("Mute");
        muteButton.setFocusable(false);
        muteButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                muteButtonItemStateChanged(evt);
            }
        });

        lblScore.setFont(new java.awt.Font("Arial", 1, 14));
        lblScore.setForeground(new java.awt.Color(219, 27, 27));
        lblScore.setText("Green Score: 0");

        lblScore2.setFont(new java.awt.Font("Arial", 1, 14));
        lblScore2.setForeground(new java.awt.Color(219, 27, 27));
        lblScore2.setText("Orange Score: 0");

        lblApples.setFont(new java.awt.Font("Arial", 1, 36));
        lblApples.setForeground(new java.awt.Color(219, 27, 27));

        org.jdesktop.layout.GroupLayout MenuPanelLayout = new org.jdesktop.layout.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(MenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(MenuPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(MenuPanelLayout.createSequentialGroup()
                        .add(MenuPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(pauseb, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(startb, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(muteButton)
                        .add(18, 18, 18)
                        .add(speedPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(bannerPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(MenuPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(GMPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblScore2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .add(lblScore, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                .add(MenuPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(MenuPanelLayout.createSequentialGroup()
                        .add(46, 46, 46)
                        .add(lblApples, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(MenuPanelLayout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 137, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(MenuPanelLayout.createSequentialGroup()
                .add(MenuPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(MenuPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(bannerPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(MenuPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(MenuPanelLayout.createSequentialGroup()
                                .add(startb)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(pauseb))
                            .add(muteButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(speedPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(MenuPanelLayout.createSequentialGroup()
                        .add(GMPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 75, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lblScore)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(lblScore2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(MenuPanelLayout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 87, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lblApples, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        speedPanel.getAccessibleContext().setAccessibleName("Difficulty");

        MenuBar.setFocusable(false);

        jMenu1.setText("File");

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        MenuBar.add(jMenu1);

        jMenu2.setText("Theme");
        jMenu2.setIconTextGap(5);

        jMenuItem9.setText("Terminal");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem8.setText("Commodore 64");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem4.setText("Superman");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenuItem4.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenuItem4MenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Batman");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem7.setText("Star Wars");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem6.setText("Standard");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        MenuBar.add(jMenu2);

        jMenu3.setText("Controls");

        jMenuItem2.setText("Show Controls");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        MenuBar.add(jMenu3);

        jMenu4.setText("About");

        jMenuItem3.setText("About");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        MenuBar.add(jMenu4);

        setJMenuBar(MenuBar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(MenuPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
            .add(boardPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(MenuPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 135, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(boardPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void startbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startbActionPerformed
        snake.initGame();
        boardPanel.requestFocusInWindow();

    }//GEN-LAST:event_startbActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed


    }//GEN-LAST:event_formKeyPressed

private void pausebStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pausebStateChanged

}//GEN-LAST:event_pausebStateChanged

private void pausebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausebActionPerformed

}//GEN-LAST:event_pausebActionPerformed

private void pausebItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pausebItemStateChanged
        int state = evt.getStateChange();

        if (state == evt.SELECTED) {
          snake.timer.stop();
          //jPanel3.requestFocusInWindow();

        } else {
          snake.timer.start();
          //jPanel3.requestFocusInWindow();
        }
}//GEN-LAST:event_pausebItemStateChanged

private void muteButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_muteButtonItemStateChanged
        int state2 = evt.getStateChange();

        if(state2 == evt.SELECTED){
            snake.muteSound();
            snake.muteshit();

        } else {
            snake.unMuteSound();
            snake.startshit();
        }

}//GEN-LAST:event_muteButtonItemStateChanged

private void jMenuItem4MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenuItem4MenuKeyPressed

}//GEN-LAST:event_jMenuItem4MenuKeyPressed

private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
  setDefaultColors();
    snake.byttSang("sounds/super.wav");
    snake.setGameOverColor(yellow);
 boardPanel.setBackground(blue);
 speedPanel.setBackground(red);
 bannerPanel.setBackground(red);
 startb.setBackground(red);
 pauseb.setBackground(red);
 muteButton.setBackground(red);
 GMPanel.setBackground(red);
 HSPanel.setBackground(red);
 lblScore.setBackground(red);
 player1Button.setBackground(red);
 player2Button.setBackground(red);
 MenuPanel.setBackground(yellow);
 SpeedSlider.setBackground(red);
 lblApples.setForeground(red);

}//GEN-LAST:event_jMenuItem4ActionPerformed

private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
 snake.byttSang("sounds/batman.wav");
     setDefaultColors();
snake.setGameOverColor(yellow);
 boardPanel.setBackground(grey2);
 speedPanel.setBackground(yellow);
 bannerPanel.setBackground(yellow);
 startb.setBackground(yellow);
 pauseb.setBackground(yellow);
 muteButton.setBackground(yellow);
 GMPanel.setBackground(yellow);
 HSPanel.setBackground(yellow);
 lblScore.setBackground(yellow);
 player1Button.setBackground(yellow);
 player2Button.setBackground(yellow);
 MenuPanel.setBackground(black);
 SpeedSlider.setBackground(yellow);
 lblScore.setForeground(yellow);
 lblScore2.setForeground(yellow);
 lblApples.setForeground(yellow);

}//GEN-LAST:event_jMenuItem5ActionPerformed

private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
 snake.byttSang("sounds/music.wav");
 snake.setGameOverColor(black);
 setDefaultColors();
 boardPanel.setBackground(natural1);
 speedPanel.setBackground(natural2);
 bannerPanel.setBackground(natural2);
 startb.setBackground(natural2);
 pauseb.setBackground(natural2);
 muteButton.setBackground(natural2);
 GMPanel.setBackground(natural2);
 HSPanel.setBackground(natural2);
 lblScore.setBackground(natural2);
 player1Button.setBackground(natural2);
 player2Button.setBackground(natural2);
 MenuPanel.setBackground(natural2);
 SpeedSlider.setBackground(natural2);
 lblScore.setForeground(c64red);
 lblScore2.setForeground(c64red);
 lblApples.setForeground(c64red);
}//GEN-LAST:event_jMenuItem6ActionPerformed

private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
   setDefaultColors();
 snake.byttSang("sounds/starwars.wav");
  snake.setGameOverColor(black);
 boardPanel.setBackground(white);
 speedPanel.setBackground(white);
 bannerPanel.setBackground(white);
 startb.setBackground(white);
 pauseb.setBackground(white);
 muteButton.setBackground(white);
 GMPanel.setBackground(white);
 HSPanel.setBackground(white);
 lblScore.setBackground(white);
 player1Button.setBackground(white);
 player2Button.setBackground(white);
 MenuPanel.setBackground(black);
 SpeedSlider.setBackground(white);
 lblScore.setForeground(white);
 lblScore2.setForeground(white);
 lblApples.setForeground(white);
}//GEN-LAST:event_jMenuItem7ActionPerformed

private void SpeedSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SpeedSliderMouseDragged
        int value = SpeedSlider.getValue();
        snake.setDelay(140 - value);
}//GEN-LAST:event_SpeedSliderMouseDragged

private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
  setDefaultColors();
  snake.setGameOverColor(c64red);
 boardPanel.setBackground(white);
 snake.byttSang("sounds/c64tune.wav");
 speedPanel.setBackground(c64red);
 bannerPanel.setBackground(white);
 startb.setBackground(c64red);
 pauseb.setBackground(c64red);
 muteButton.setBackground(c64red);
 GMPanel.setBackground(c64red);
 HSPanel.setBackground(c64red);
 lblScore.setBackground(c64red);
 player1Button.setBackground(c64red);
 player2Button.setBackground(c64red);
 MenuPanel.setBackground(c64blue);
 SpeedSlider.setBackground(c64red);
 lblScore.setForeground(c64red);
 lblScore2.setForeground(c64red);
 lblApples.setForeground(c64red);

}//GEN-LAST:event_jMenuItem8ActionPerformed

private void player1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player1ButtonActionPerformed
snake.setMultiplayer(false);
boardPanel.requestFocus();
}//GEN-LAST:event_player1ButtonActionPerformed

private void player2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2ButtonActionPerformed
snake.setMultiplayer(true);
boardPanel.requestFocus();
}//GEN-LAST:event_player2ButtonActionPerformed

private void setDefaultColors() {
     startb.setForeground(null);
    pauseb.setForeground(null);
    muteButton.setForeground(null);
    SpeedSlider.setForeground(null);
    GMPanel.setForeground(null);
    HSPanel.setForeground(null);
    lblScore.setForeground(null);
    player1Button.setForeground(null);
    player2Button.setForeground(null);
    jLabel1.setForeground(null);
    MenuPanel.setForeground(null);
    boardPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    MenuPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    bannerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    GMPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(null, null), "Game Modes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
    HSPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(null, null), "Highscore", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
    speedPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(null, null), "Adjust Speed", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));

}
private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
     snake.byttSang("sounds/terminal.wav");
     snake.setGameOverColor(green);
    boardPanel.setBackground(black);
    speedPanel.setBackground(black);
    bannerPanel.setBackground(black);
    startb.setBackground(black);
    pauseb.setBackground(black);
    muteButton.setBackground(black);
    GMPanel.setBackground(black);
    HSPanel.setBackground(black);
    lblScore.setBackground(black);
    player1Button.setBackground(black);
    player2Button.setBackground(black);
    MenuPanel.setBackground(black);
    SpeedSlider.setBackground(black);
    lblScore2.setForeground(green);
    lblApples.setForeground(green);

    startb.setForeground(green);
    pauseb.setForeground(green);
    muteButton.setForeground(green);
    SpeedSlider.setForeground(green);
    GMPanel.setForeground(green);
    HSPanel.setForeground(green);
    lblScore.setForeground(green);
    player1Button.setForeground(green);
    player2Button.setForeground(green);
    jLabel1.setForeground(Color.green);
    MenuPanel.setForeground(green);
    boardPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
    MenuPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
    bannerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
    GMPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.green, java.awt.Color.green), "Game Modes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 204, 0)));
    HSPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.green, java.awt.Color.green), "Highscore", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 204, 0)));
    speedPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.green, java.awt.Color.green), "Adjust Speed", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 204, 0)));

}//GEN-LAST:event_jMenuItem9ActionPerformed

private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
controlSplash = new SplashScreen("gfx/controlSplash.gif");
controlSplash.open(5000);
}//GEN-LAST:event_jMenuItem2ActionPerformed

private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
aboutScreen = new About();
aboutScreen.setTitle("About Snejk");
//aboutScreen.setSize(650,600);
aboutScreen.setLocationRelativeTo(null);
aboutScreen.setDefaultCloseOperation(About.DISPOSE_ON_CLOSE);
aboutScreen.setResizable(false);
aboutScreen.setVisible(true);

}//GEN-LAST:event_jMenuItem3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GMPanel;
    private javax.swing.ButtonGroup GMbgroup;
    public javax.swing.JList HSPanel;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JSlider SpeedSlider;
    private javax.swing.JPanel bannerPanel;
    private javax.swing.JPanel boardPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblApples;
    public javax.swing.JLabel lblScore;
    public javax.swing.JLabel lblScore2;
    private javax.swing.JToggleButton muteButton;
    private javax.swing.JToggleButton pauseb;
    private javax.swing.JRadioButton player1Button;
    private javax.swing.JRadioButton player2Button;
    private javax.swing.JPanel speedPanel;
    private javax.swing.JButton startb;
    // End of variables declaration//GEN-END:variables

    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}