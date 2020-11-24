package game_app;

import javafx.scene.image.Image;

public class Log extends Actor {
/**@Refactor
 * self encapsulating field to avoid direct access of field 
 * even within own class
 * create setter and getter for encapsulated field 
 */

	private double speed;
	@Override
	public void act(long now) {
		move(getSpeed() , 0);
		if (getX()>600 && getSpeed()>0)
			setX(-180);
		if (getX()<-300 && getSpeed()<0)
			setX(700);
	}
	
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		//speed = s;
		setSpeed(s);
		
	}
	/** @Refactor
	 * rename getLeft to moveLeft
	 */
	public boolean moveLeft() {
		return speed < 0;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void setSpeed(double sp) {
		speed = sp;
	}
}
