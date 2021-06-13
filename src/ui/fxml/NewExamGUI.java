package ui.fxml;

import exceptions.EmptyEvaluationException;
import exceptions.OutOfDateException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Course;

import java.time.LocalDate;

public class NewExamGUI {

    private Course currentCourse;

    public void initialize (Course c) {
        currentCourse = c;
    }

    @FXML
    private AnchorPane adminPane;

    @FXML
    private TextField newExamNameTextField;

    @FXML
    private TextField newExamPercentageTextField;

    @FXML
    private TextArea newExamContentTextArea;

    @FXML
    private TextField newExamLimitTimeTextField;

    @FXML
    void createExam(ActionEvent event) {
        if (!hasEmptyField()) {
            try {
                String name = newExamNameTextField.getText();
                int percentage = Integer.parseInt(newExamPercentageTextField.getText());
                String content = newExamContentTextArea.getText();
                int timeLimit = Integer.parseInt(newExamLimitTimeTextField.getText());

                if (currentCourse.addExam(name,percentage,content, timeLimit)){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Crear Exámen");
                    alert.setHeaderText("El exámen ha sido creado exitosamente");
                    alert.setContentText("Presione OK");
                    alert.showAndWait();
                }
            }catch (EmptyEvaluationException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("EmptyEvaluationException");
                alert.setHeaderText("Evaluación sin contenido");
                alert.setContentText("No se puede crear una evaluación sin contenido. \n\nInténtelo de nuevo.");
                alert.showAndWait();
            }catch (NumberFormatException numberFormatException) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("NumberFormatException");
                alert.setHeaderText("Formato inválido");
                alert.setContentText("El porcentaje del exámen o el tiempo límite está en un formato que no es numérico. \n\nInténtelo de nuevo.");
                alert.showAndWait();
            }
        }
    }

    private boolean hasEmptyField() {
        boolean emptyField = newExamNameTextField.getText().isEmpty() || newExamPercentageTextField.getText().isEmpty();

        if (newExamLimitTimeTextField.getText().isEmpty()) {
            emptyField = true;
        }
        return emptyField;
    }
}
