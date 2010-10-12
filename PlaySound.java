/*
 * PlaySound is used to play audio from a given *.wav file
 * and open the template in the editor.
 */


/**
 *
 * @author Andreas Myrhaug, Stian Sorebo and Oyvind Selmer
 */
import java.applet.AudioClip;

public class PlaySound {
    private AudioClip lyd;
    String filename;
    /**Load audioclip
     *
     * @param startFilename
     */
    public PlaySound(String startFilename) {
        filename = startFilename;
    }
    /**Play the loaded audioclip
     *
     */
    public void spillLyd() {

        lyd = java.applet.Applet.newAudioClip(getClass().getResource(filename));

        lyd.play();

}   /**stop sound
     *
     */
    public void stoppLyd(){
        lyd.stop();
    }
    /**Loop sound
     *
     */
    public void loopLyd(){
        lyd = java.applet.Applet.newAudioClip(getClass().getResource(filename));
        lyd.loop();
    }
}
