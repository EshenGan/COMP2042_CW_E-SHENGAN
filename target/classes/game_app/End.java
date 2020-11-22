package game_app;

import javafx.scene.image.Image;

public class End extends Actor{
	/**@Refactor
	 * encapsulate field and created setter and getter method
	 * act(long now) method pulled to superclass
	 */
	private boolean activated = false;
	
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/game_app/End.png", 60, 60, true, true));
	}
	
	public void setEnd() {
		setImage(new Image("file:src/game_app/FrogEnd.png", 60, 60, true, true));
		//activated = true;
		setActivated(true);
	}
	
	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	

}
