package game_app;

import javafx.scene.image.Image;

public class WetTurtle extends Actor{
	/**@Refactor
	 * field encapsulation
	 * removal of unused field
	 */
	private Image turtle1;
	private Image turtle2;
	private Image turtle3;
	private Image turtle4;
	private int speed;
	// private int i = 1;
	//private boolean bool = true;
	private boolean sunk = false;
	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(turtle2);
					//sunk = false;
					setSunk(false);
					
				}
				else if (now/900000000 % 4 == 1) {
					setImage(turtle1);
					//sunk = false;
					setSunk(false);
				}
				else if (now/900000000 %4 == 2) {
					setImage(turtle3);
					//sunk = false;
					setSunk(false);
				} else if (now/900000000 %4 == 3) {
					setImage(turtle4);
					//sunk = true;
					setSunk(true);
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image("file:src/game_app/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/game_app/TurtleAnimation2Wet.png", w, h, true, true);
		turtle3 = new Image("file:src/game_app/TurtleAnimation3Wet.png", w, h, true, true);
		turtle4 = new Image("file:src/game_app/TurtleAnimation4Wet.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
	
	public void setSunk(boolean b) {
		sunk = b;
	}
	public boolean isSunk() {
		return sunk;
	}
}
