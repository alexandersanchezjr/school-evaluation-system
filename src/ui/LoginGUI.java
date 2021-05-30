package ui;

import javafx.event.ActionEvent;
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
import model.EvaluationSystem;

import java.io.IOException;

public class LoginGUI {

    EvaluationSystem evaluationSystem;
    ManagerGUI managerGUI;
    RegisterGUI registerGUI;


    @FXML
    private AnchorPane mainWelcomePane;

    @FXML
    private TextField institutionalCodeTextField;

    @FXML
    private PasswordField passwordField;

    public LoginGUI(EvaluationSystem evaluationSystem) {
        this.evaluationSystem = evaluationSystem;
        managerGUI = new ManagerGUI(evaluationSystem, this);
        registerGUI = new RegisterGUI();
    }

    @FXML
    void logIn(ActionEvent event) {
        if (true) {    //TODO check if the user does exist and make a separate method
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

}
