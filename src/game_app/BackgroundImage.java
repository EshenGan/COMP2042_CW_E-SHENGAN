package game_app;

import javafx.scene.image.Image;

public class BackgroundImage extends Actor{
	/**@Refactor
	 * act(long now) method pulled to superclass
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600,800, true, true));
		
	}

}
