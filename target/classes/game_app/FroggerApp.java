/**
 * @Refactor 
 *  renaming of package and Main java file with meaningful name
 *  remove unused imports
 */
package game_app;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class FroggerApp extends Application {
	AnimationTimer timer;
	MyStage background;
	Frog frog1;
	/**
	 * @Refactor
	 * set up aggregated field here before instantiating as object in start(Stage primaryStage);
	 */
	Scene scene;
	BackgroundImage froggerbackground;
	
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * @Override
	 * method overriding on application class
	 */
	public void start(Stage primaryStage) throws Exception {
	    background = new MyStage();
	    scene  = new Scene(background,600,800);
		froggerbackground = new BackgroundImage("file:src/game_app/try1.jpg");
		frog1 = new Frog("file:src/game_app/froggerUp.png");
		primaryStage.setScene(scene);
		background.add(froggerbackground);
		background.add(new Digit(0, 30, 360, 25));
		buildLogs();
		buildTurtles();
		buildFrogHome();
		background.add(frog1);//DO NOT EVER MOVE THIS method below to other place		
		buildObstacles();
		primaryStage.show();
		start();

	}

	public void start() {
		background.start();
		background.playMusic();
    	createTimer();
        timer.start();
    }

	@Override 
    public void stop() {
        timer.stop();
    }
	
	//try to refactor this
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (frog1.changeScore()) {
            		setNumber(frog1.getPoints());
            	}
            	if (frog1.getStop()) {
            		System.out.print("STOP:");
            		background.stopMusic();
            		stop();
            		background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+frog1.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
            }
        };
    }
	
    
    //still dont understand how this work
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 360 - shift, 25));
    		  shift+=30;
    		}
    }
    /**
     * @Refactor
     * extract method
     */
    public void buildFrogHome() {
    	int ax = 13 , bx= 141 , cx=141+141-13;
    	int dx = 141+141-13+141-13+1, ex=141+141-13+141-13+141-13+3;
    	int y = 96;
		background.add(new End(ax,y));
		background.add(new End(bx,y));
		background.add(new End(cx,y));
		background.add(new End(dx,y));
		background.add(new End(ex,y));
    }
    
    /**<newline>
     * @Refactor
     * extract method
     */
    public void buildLogs() {
    	//should i extract the parameters into objects instead?
		background.add(new Log("file:src/game_app/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:src/game_app/log3.png", 150, 220, 166, 0.75));
		background.add(new Log("file:src/game_app/log3.png", 150, 440, 166, 0.75));
		//background.add(new Log("file:src/game_app/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:src/game_app/logs.png", 300, 0, 276, -2));
		background.add(new Log("file:src/game_app/logs.png", 300, 400, 276, -2));
		///background.add(new Log("file:src/game_app/logs.png", 300, 800, 276, -2));
		background.add(new Log("file:src/game_app/log3.png", 150, 50, 329, 0.75));
		background.add(new Log("file:src/game_app/log3.png", 150, 270, 329, 0.75));
		background.add(new Log("file:src/game_app/log3.png", 150, 490, 329, 0.75));
		///background.add(new Log("file:src/game_app/log3.png", 150, 570, 329, 0.75));
		//background.add(new Log("file:src/game_app/log2.png", 200, 100,300, 1));
		//background.add(new Log("file:src/game_app/log2.png", 0, 100, 1));
		//background.add(new Log("file:src/game_app/log2.png", 100, 120, -1));
		//background.add(new Log("file:src/game_app/log2.png", 200, 120, -1));
		//background.add(new Log("file:src/game_app/log2.png", 100, 140, 1));
		//background.add(new Log("file:src/game_app/log2.png", 200, 140, 1));
		//background.add(new Log("file:src/game_app/log2.png", 100, 160, -1));
		//background.add(new Log("file:src/game_app/log2.png", 300, 160, -1));
		//background.add(new Log("file:src/game_app/log2.png", 100, 180, 1));
		//background.add(new Log("file:src/game_app/log2.png", 200, 180, 1));
		//background.add(new Log("file:src/game_app/log2.png", 100, 200, -1));
		//background.add(new Log("file:src/game_app/log2.png", 200, 200, -1));
		//background.add(new Log("file:src/game_app/log2.png", 100, 220, 1));
		//background.add(new Log("file:src/game_app/log2.png", 200, 220, 1));
		//background.add(new Log("file:src/game_app/log2.png", 400, 220, 1));
    }
    
    /**
     * @Refactor
     * extract method
     */
    public void buildTurtles() {
		background.add(new Turtle(500, 376, -1, 130, 130));
		background.add(new Turtle(300, 376, -1, 130, 130));
		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));
    
    }
    
    /**@Refactor
     * extract method
     */
    public void buildObstacles() {
		background.add(new Obstacle("file:src/game_app/truck1Right.png", 0, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/game_app/truck1Right.png", 300, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/game_app/truck1Right.png", 600, 649, 1, 120, 120));
		//background.add(new Obstacle("file:src/game_app/truck1"+"Right.png", 720, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/game_app/car1Left.png", 100, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/game_app/car1Left.png", 250, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/game_app/car1Left.png", 400, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/game_app/car1Left.png", 550, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/game_app/truck2Right.png", 0, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/game_app/truck2Right.png", 500, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/game_app/car1Left.png", 500, 490, -5, 50, 50));   	
    }
}
