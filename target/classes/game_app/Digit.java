package game_app;

import javafx.scene.image.Image;

public class Digit extends Actor{
	int dim;
	Image im1;
	/**@Refactor
	 * act(long now) method pulled to superclass
	 */
	
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/game_app/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
