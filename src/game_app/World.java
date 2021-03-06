/**@Remove
 * remove all unused imports
 */
package game_app;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;



public abstract class World extends Pane {
	/**@Refactor
	 * self encapsulating field to avoid direct access of field  even within own class
	 * create setter and getter for encapsulated field
	 */
    private AnimationTimer timer;
    
    public World() {
    	
    	sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
						
					}); 	
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
						
					});
				}
				
			}
    		
		});
    }

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                List<Actor> actors = getObjects(Actor.class);
                
                for (Actor anActor: actors) {
                	anActor.act(now);
                }
      
            }
        };
    }
    
    public AnimationTimer getTimer() {
    	return timer;
    }

    public void start() {
    	createTimer();
        getTimer().start();
    }

    public void stop() {
        getTimer().stop();
    }
    
    public void add(Actor actor) {
        getChildren().add(actor);
    }

    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    /** @refactor 
     * remove assignments to parameters 
     *  assigned (A)n to variable a of type A before passing a to .add()
     *  instead of someArray.add((A)n);
     *  added try and catch
     */
    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
            	try {
                	A a = (A)n;
    				someArray.add(a);
            	}
            	catch(Exception e) {
            		System.out.println(e);
            	}

            	
            }
        }
        return someArray;
    }

    //public abstract void act(long now);
    /** @Refactor
     * pull up method from subclass MyStage
     */
    public void act(long now) {}
}
