package game_app;

import javafx.scene.image.Image;

public class Turtle extends Actor{
	/**@Refactor
	 * field encapsulation
	 * removal of unused field
	 */
	private Image turtle1;
	private Image turtle2;
	private Image turtle3;
	private int speed;
	//private int i = 1;
	//private boolean bool = true;
	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(turtle2);
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtle1);
					
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtle3);
					
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	public Turtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image("file:src/game_app/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/game_app/TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image("file:src/game_app/TurtleAnimation3.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
}
