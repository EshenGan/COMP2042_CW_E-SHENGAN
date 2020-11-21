package game_app;

import javafx.scene.image.Image;

public class Digit extends Actor{
	int dim;
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/game_app/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
