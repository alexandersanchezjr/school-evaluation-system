package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Course;
import model.EvaluationSystem;

import java.time.LocalDate;

public class NewQuestionnaireGUI {

    private Course currentCourse;

    @FXML
    private TextField newNameTextField;

    @FXML
    private TextField newPercentageTextField;

    @FXML
    private TextArea newQuestionnaireContentTextArea;

    @FXML
    private Spinner<Integer> newAttemptsSpinner;

    @FXML
    private DatePicker newInitialDatePicker;

    public void initialize (Course c) {
        currentCourse = c;
        newAttemptsSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 2));

    }

    @FXML
    void createQuestionnaire(ActionEvent event) {

        if(!hasEmptyField()){
            String topic = newNameTextField.getText();
            int percentage = Integer.parseInt(newPercentageTextField.getText());
            String content = newQuestionnaireContentTextArea.getText();
            LocalDate date = newInitialDatePicker.getValue();
            int attempts = newAttemptsSpinner.getValue();

            if (currentCourse.addQuestionnaire(topic, percentage, content, date, attempts)){

            }

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Campos Vacíos");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, rellene todos los campos para poder crear un cuestionario");
            alert.showAndWait();
        }
    }

    private boolean hasEmptyField() {
        boolean emptyField = newNameTextField.getText().isEmpty() || newPercentageTextField.getText().isEmpty() || newQuestionnaireContentTextArea.getText().isEmpty();

        if (newAttemptsSpinner.getValue() == null){
            emptyField = true;
        }
        if (newInitialDatePicker.getValue() == null) {
            emptyField = true;
        }
        return emptyField;

    }

}
