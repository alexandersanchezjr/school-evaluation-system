package ui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.Ball;

public class CreditsGUI {

    private Ball b1;
    private Ball b2;
    private Ball b3;
    private Ball b4;
    private Ball b5;
    private Ball b6;

    private boolean bouncing;

    @FXML
    private Pane pane;

    @FXML
    private Circle ball1;

    @FXML
    private Circle ball4;

    @FXML
    private Circle ball2;

    @FXML
    private Circle ball5;

    @FXML
    private Circle ball6;

    @FXML
    private Circle ball3;

    public CreditsGUI () {
        bouncing = true;
    }

    public void initialize () {
        b1 = new Ball(ball1.getLayoutX(), ball1.getRadius());
        b2 = new Ball(ball2.getLayoutX(), ball2.getRadius());
        b3 = new Ball(ball3.getLayoutX(), ball3.getRadius());
        b4 = new Ball(ball4.getLayoutX(), ball4.getRadius());
        b5 = new Ball(ball5.getLayoutX(), ball5.getRadius());
        b6 = new Ball(ball6.getLayoutX(), ball6.getRadius());

        moveBalls();
    }

    private void moveBalls() {
        setMax();
        new Thread() {
            public void run() {
                while(bouncing) {
                    move();

                    Platform.runLater(new Thread() {
                        public void run() {
                            updateCircles();
                        }
                    });

                    try {
                        Thread.sleep(8);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    private void setMax() {
        b1.setMax(pane.getWidth());
        b2.setMax(pane.getWidth());
        b3.setMax(pane.getWidth());
        b4.setMax(pane.getWidth());
        b5.setMax(pane.getWidth());
        b6.setMax(pane.getWidth());
    }

    private void move() {
        b1.move();
        b2.move();
        b3.move();
        b4.move();
        b5.move();
        b6.move();
    }

    private void updateCircles () {
        ball1.setLayoutX(b1.getX());
        ball2.setLayoutX(b2.getX());
        ball3.setLayoutX(b3.getX());
        ball4.setLayoutX(b4.getX());
        ball5.setLayoutX(b5.getX());
        ball6.setLayoutX(b6.getX());
    }
}
