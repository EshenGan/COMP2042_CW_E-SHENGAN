package game_app;

import javafx.scene.image.Image;

public class Digit extends Actor{
	/**@refactor
	 * removed unused field
	 * act(long now) method pulled to superclass
	 */
	//private int dim;
	Image im1;
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/game_app/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
