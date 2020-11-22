package game_app;

import javafx.scene.image.Image;

public class Obstacle extends Actor {
	/**@Refactor
	 * encapsulate field , create setter and getter method
	 */
	private int speed;
	@Override
	public void act(long now) {
		move(getSpeed() , 0);
		if (getX() > 600 && getSpeed()>0)
			setX(-200);
		if (getX() < -50 && getSpeed()<0)
			setX(600);
	}
	
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}
	public int getSpeed() {
		return speed;
	}

}
