package ui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.EvaluationSystem;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ManagerGUI {

    private EvaluationSystem evaluationSystem;
    private LoginGUI loginGUI;

    @FXML
    private Label timeLabel;

    @FXML
    private AnchorPane mainPane;

    public ManagerGUI(EvaluationSystem evaluationSystem, LoginGUI loginGUI) {
        this.evaluationSystem = evaluationSystem;
        this.loginGUI = loginGUI;
    }

    @FXML
    void logOut(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/login.fxml"));

        fxmlLoader.setController(loginGUI);
        Parent LoginWindow = null;
        try {
            LoginWindow = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene loginScene = new Scene (LoginWindow);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(loginScene);
        window.show();
    }

    @FXML
    void showAssessmentsPane(ActionEvent event) {

    }

    @FXML
    void showCoursesPane(ActionEvent event) {

    }

    @FXML
    void showExamsPane(ActionEvent event) {

    }

    @FXML
    void showQuestionnairesPane(ActionEvent event) {

    }

    public void timer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Date date = new Date ();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
                Platform.runLater(() -> timeLabel.setText(sdf.format(date)));
            }
        }, 0, 1000);
    }
}
