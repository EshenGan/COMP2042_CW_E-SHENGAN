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
	 * self encapsulating field to avoid direct access of field  even within own class
	 * create setter and getter for encapsulated field
	 */
	public void playMusic() {
		//String musicFile = "src/game_app/Frogger Main Song Theme (loop).mp3";   
		//Media sound = new Media(new File(musicFile).toURI().toString());
		//mediaPlayer = new MediaPlayer(sound);
		setMediaPlayer();
		getMediaPlayer();
		getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
	    //mediaPlayer.play();
		getMediaPlayer().play();
	}
	
	public void stopMusic() {
		mediaPlayer.stop();
	}
	
	public void setMediaPlayer() {
		String musicFile = "src/game_app/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
	}
	
	public MediaPlayer getMediaPlayer() {
		 return mediaPlayer;
	}

}
