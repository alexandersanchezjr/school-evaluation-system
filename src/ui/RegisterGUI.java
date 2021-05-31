package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import model.EvaluationSystem;
import model.Teacher;

public class RegisterGUI {

    EvaluationSystem evaluationSystem;

    @FXML
    private GridPane mainRegisterGridPane;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField surnameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField codeTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private ToggleButton availabilityToogleButton;

    public RegisterGUI (EvaluationSystem evaluationSystem) {
        this.evaluationSystem = evaluationSystem;
    }

    @FXML
    void changeAvailability(ActionEvent event) {

    }

    @FXML
    void goBack(ActionEvent event) {

    }

    @FXML
    void register(ActionEvent event) {
        if(nameTextField.getText().isEmpty() || surnameTextField.getText().isEmpty() || emailTextField.getText().isEmpty() || codeTextField.getText().isEmpty() || passwordTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Campo vacío");
            alert.setHeaderText("Dejaste un campo por completar");
            alert.setContentText("Por favor, rellena todos los campos");
            alert.showAndWait();
        }else{
            Teacher teacherToRegister = evaluationSystem.searchTeacher(codeTextField.getText());
            if (teacherToRegister == null){
                evaluationSystem.addTeacher(nameTextField.getText(), surnameTextField.getText(), emailTextField.getText(), codeTextField.getText(), passwordTextField.getText(), checkAvailability());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registro exitoso");
                alert.setHeaderText("Su cuenta ya ha sido creada");
                alert.setContentText("Vaya atrás e intente registrarse");
                alert.showAndWait();

            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Registro no exitoso");
                alert.setHeaderText("Ya existe una cuenta con ese código");
                alert.setContentText("Inténtelo de nuevo con otro código.");
                alert.showAndWait();
            }
        }
    }

    private boolean checkAvailability () {
        if (availabilityToogleButton.isSelected())
            return false;
        else
            return true;
    }
}
