/**@Remove
 * remove all unused imports
 */
package game_app;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class MyStage extends World{
	private MediaPlayer mediaPlayer;
	/**@Refactor
	 * act method pulled to superclass
	 */	
	public void playMusic() {
		String musicFile = "src/game_app/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
