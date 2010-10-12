/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**This Class will handle and store HighScore objects
 *
 *  @author Andreas Myrhaug, Stian Sorebo and Oyvind Selmer
 */
import java.io.*;


public class HighScoreHandler {

    private HighScore[] highScores = new HighScore[3];
    /**Generates a HighScoreHandler object
     *
     */
    public HighScoreHandler() {

    }
    /**Adds a new player and score to the HighScore list Then uses bubble sort algorithm to sort the list
     *
     * @param name
     * @param score
     */
    public void newHighScore(String name, int score) {
      HighScore t = new HighScore(null, 0);
      highScores[2] = new HighScore(name, score);
      for(int i=0;i<highScores.length;i++) {
        for(int j=1;j<(highScores.length -i);j++) {
            if(highScores[j-1].getScore() < highScores[j].getScore()) {
                t = highScores[j];
                highScores[j] = highScores[j-1];
                highScores[j-1]=t;
            }
	}
    }
}
    /**Used to generate a default "higscore.ser" file
     *
     * @throws java.io.IOException
     * @throws java.lang.Exception
     */
    public void highScoreTable()throws IOException, Exception {
        highScores = new HighScore[3];
        highScores[0] = new HighScore("Myrhaugen", 200);
        highScores[1] = new HighScore("Selmer", 100);
        highScores[2] = new HighScore("Jinxen", 10);
        writeHighScores();
    }
    /**Write the "highscore.ser" file
     *
     * @throws java.io.IOException
     * @throws java.lang.Exception
     */
    public void writeHighScores() throws IOException, Exception {
        FileOutputStream outStream = new FileOutputStream("highscore.ser");
	ObjectOutputStream output = new ObjectOutputStream(outStream);
	output.writeObject(highScores);
	output.close();

     }
    /**Load the "highscore.ser" file
     *
     * @return HighScore[]
     * @throws java.io.IOException
     * @throws java.lang.Exception
     */
    public HighScore[] loadHighScores() throws IOException, Exception{
        FileInputStream inStream = new FileInputStream("highscore.ser");
	ObjectInputStream input = new ObjectInputStream(inStream);
        highScores = (HighScore[])input.readObject();
        input.close();
        for(int i=0;i<highScores.length;i++) {
            if(highScores[i] == null)highScores[i]=new HighScore("Default", 0);
        }
        return highScores;
    }
}









