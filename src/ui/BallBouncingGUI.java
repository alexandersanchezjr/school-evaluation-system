package ui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Ball;

public class BallBouncingGUI {

    @FXML
    private Circle shCircle;
    
    private Stage window;
    
    private Ball b;
    
    private boolean bouncing;
    
    public BallBouncingGUI(Stage st) {
    	window = st;
    	bouncing = true;
    }
    
    public void initialize() {
    	b = new Ball(shCircle.getLayoutX(),shCircle.getRadius());
    	
    	window.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				bouncing = false;
				System.out.println("Closing the window!");
			}
		});
    }
    
    @FXML
    public void moveBall(ActionEvent event) {
    	b.setMax(window.getWidth());
    	new Thread() {
    		public void run() {
    			while(bouncing) {
    				b.move();
    				
    				Platform.runLater(new Thread() {
    					public void run() {
    						updateCircle(b.getX());
    					}
    				});
    				
    				try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
    			}
    		}
    	}.start();
    }
    
    public void updateCircle(double x) {
    	shCircle.setLayoutX(x);
    }

}
