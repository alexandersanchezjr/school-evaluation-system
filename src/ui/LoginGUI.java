package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.EvaluationSystem;
import model.Teacher;

import java.io.IOException;

public class LoginGUI {

    EvaluationSystem evaluationSystem;
    ManagerGUI managerGUI;
    RegisterGUI registerGUI;
    Stage window;


    @FXML
    private AnchorPane mainWelcomePane;

    @FXML
    private TextField institutionalCodeTextField;

    @FXML
    private PasswordField passwordField;

    public LoginGUI(EvaluationSystem evaluationSystem, Stage w) {
        this.evaluationSystem = evaluationSystem;
        managerGUI = new ManagerGUI(evaluationSystem, this);
        registerGUI = new RegisterGUI(evaluationSystem, this);
        window = w;
    }

    public void initialize() {

        window.setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent event) {
                System.out.println("Closing the window!");
                try {
                    evaluationSystem.saveEvaluationSystemData();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @FXML
    void logIn(ActionEvent event) {
        if (exist(institutionalCodeTextField.getText(), passwordField.getText()) != null) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/manager.fxml"));

            fxmlLoader.setController(managerGUI);
            Parent ManagerWindow = null;
            try {
                ManagerWindow = fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene managerScene = new Scene (ManagerWindow);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(managerScene);
            window.show();
            managerGUI.timer();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Inicio de sesión erróneo");
            alert.setHeaderText("El código institucional y/o la contraseña no coinciden.");
            alert.setContentText("Inténtelo de nuevo.");
            alert.showAndWait();
            institutionalCodeTextField.setText("");
            passwordField.setText("");
        }
    }

    @FXML
    void registerTeacher(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/register.fxml"));

        fxmlLoader.setController(registerGUI);
        Parent RegisterWindow = null;
        try {
            RegisterWindow = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene registerScene = new Scene (RegisterWindow);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(registerScene);
        window.show();
    }

    private Teacher exist(String codeToSearch, String passwordToSearch) {
        Teacher logged = null;
            if(evaluationSystem.searchTeacher(codeToSearch) != null && evaluationSystem.searchTeacher(codeToSearch).getPassword().equals(passwordToSearch)) {
                logged = evaluationSystem.searchTeacher(codeToSearch);
                evaluationSystem.setLogged(logged);
            }
        return logged;
    }

}
