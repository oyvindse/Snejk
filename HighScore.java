



/** HighScore
 *
 *  @author Andreas Myrhaug, Stian Sorebo and Oyvind Selmer
 */
import java.io.*;
public class HighScore implements Serializable{

    private String name;
    private int score;
   /** Generates a HighScore object
    *
    * @param startName
    * @param startScore
    */
    public HighScore(String startName, int startScore) {
        name = startName;
        score = startScore;

    }
    /**Get player name
     *
     * @return name
     */
    public String getName() {
        return name;
    }
    /**Get player score
     *
     * @return score
     */
    public int getScore() {
        return score;
    }
    /**set player name
     *
     * @param inputName
     */
    public void setName(String inputName) {
        name = inputName;
    }
    /**Set player score
     *
     * @param inputScore
     */
    public void setScore(int inputScore) {
        score = inputScore;
    }
    /**toString method to print out information about the object
     *
     * @return String
     */
    public String toString() {
        return ""+name +": "+score;
    }

}

