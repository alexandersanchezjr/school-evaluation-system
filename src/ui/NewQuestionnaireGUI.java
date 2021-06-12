package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Course;
import model.EvaluationSystem;

import java.time.LocalDate;

import exceptions.EmptyEvaluationException;

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

            try {
				if (currentCourse.addQuestionnaire(topic, percentage, content, date, attempts)){

				}
			} catch (EmptyEvaluationException e) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("EmptyEvaluationException");
				alert.setHeaderText("No ha sido posible agregar el nuveo cuestionario");
				alert.setContentText(e.getMessage() + "\n\nInténtelo de nuevo.");
				alert.showAndWait();
				e.printStackTrace();
			}

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Campos VacÃ­os");
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
