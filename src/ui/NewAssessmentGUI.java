package ui;

import exceptions.EmptyEvaluationException;
import exceptions.OutOfDateException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Course;

import java.time.LocalDate;

public class NewAssessmentGUI {

    private Course currentCourse;

    @FXML
    private TextField newAssessmentNameTextField;

    @FXML
    private TextField newAssessmentPercentageTextField;

    @FXML
    private TextArea newAssessmentContentTextArea;

    @FXML
    private DatePicker newInitialDatePicker;

    @FXML
    private TextArea newAssessmentAnswersTextArea;

    public void initialize (Course e) {
        currentCourse = e;
    }

    @FXML
    void createAssessment(ActionEvent event) {
        if (!hasEmptyField()) {
            try {
                String name = newAssessmentNameTextField.getText();
                int percentage = Integer.parseInt(newAssessmentPercentageTextField.getText());
                String content = newAssessmentContentTextArea.getText();
                LocalDate date = newInitialDatePicker.getValue();
                String answers = newAssessmentAnswersTextArea.getText();

                if (currentCourse.addWorkshop(name,percentage,content, date, answers)){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Crear Taller");
                    alert.setHeaderText("El taller ha sido creado exitosamente");
                    alert.setContentText("Presione OK");
                    alert.showAndWait();
                }
            }catch (EmptyEvaluationException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("EmptyEvaluationException");
                alert.setHeaderText("Evaluación sin contenido");
                alert.setContentText("No se puede crear una evaluación sin contenido. \n\nInténtelo de nuevo.");
                alert.showAndWait();
            } catch (OutOfDateException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("OutOfDateException");
                alert.setHeaderText("Fecha fuera de rango");
                alert.setContentText(e.getMessage() + "\n\nIntente ingresando otra fecha.");
                alert.showAndWait();
                e.printStackTrace();
            }catch (NumberFormatException numberFormatException) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("NumberFormatException");
                alert.setHeaderText("Formato inválido");
                alert.setContentText("El porcentaje del cuestionario está en un formato que no es numérico. \n\nInténtelo de nuevo.");
                alert.showAndWait();
            }
        }
    }

    private boolean hasEmptyField() {
        boolean emptyField = newAssessmentNameTextField.getText().isEmpty() || newAssessmentPercentageTextField.getText().isEmpty();
        if (newInitialDatePicker.getValue() == null) {
            emptyField = true;
        }
        return emptyField;
    }
}
