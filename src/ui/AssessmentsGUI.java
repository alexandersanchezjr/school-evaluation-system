package ui;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class AssessmentsGUI {

    private EvaluationSystem evaluationSystem;
    private Course selectedCourse;

    @FXML
    private TableView<Workshop> assessmentsTableView;

    @FXML
    private TableColumn<Workshop, String> tcAssessmentsName;

    @FXML
    private TableColumn<Workshop, String> tcAssessmentsPercentage;

    @FXML
    private TableColumn<Workshop, String> tcAssessmentsInitialDate;

    @FXML
    private TextField assessmentNameTextField;

    @FXML
    private TextField assessmentPercentageTextField;

    @FXML
    private TextArea assessmentContentTextArea;

    @FXML
    private DatePicker initialDatePicker;

    @FXML
    private ComboBox<Course> coursesComboBox;

    public AssessmentsGUI(EvaluationSystem evaluationSystem) {
        this.evaluationSystem = evaluationSystem;
    }

    private void initializeComboBox () {
        ArrayList<Course> courses = evaluationSystem.getLogged().getCourses();
        ObservableList<Course> list = FXCollections.observableArrayList(courses);
        coursesComboBox.setItems(list);
    }

    private void initializeAssessmentTableView() {
        ObservableList<Workshop> list = FXCollections.observableArrayList(selectedCourse.getAssessments());
        assessmentsTableView.setItems(list);
        tcAssessmentsName.setCellValueFactory(new PropertyValueFactory<Workshop, String>("topic"));
        tcAssessmentsPercentage.setCellValueFactory(new PropertyValueFactory<Workshop, String>("percentage"));
        tcAssessmentsInitialDate.setCellValueFactory(new PropertyValueFactory<Workshop, String>("assignmentDate"));
        assessmentsTableView.refresh();
    }

    @FXML
    void checkAnswers(ActionEvent event) {
        //TODO create check answers pane and finished this method
    }

    @FXML
    void cleanList(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Confirme borrado de datos");
        dialog.setHeaderText("Por favor, escriba 'SI' si desea limpiar la lista de talleres ");

        // Traditional way to get the response value.
        String input = "";
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            input = result.get();
        }
        if (input.equals("SI")) {
            selectedCourse.cleanAssessments();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Operación exitosa");
            alert.setHeaderText("Lista de cuestionarios eliminada");
            alert.setContentText("Todos los cuestionarios han sido borrados existosamente. Presione OK");
            alert.showAndWait();

            initializeAssessmentTableView();
            assessmentNameTextField.setDisable(true);
            assessmentNameTextField.setText(null);

            assessmentPercentageTextField.setDisable(true);
            assessmentPercentageTextField.setText(null);

            assessmentContentTextArea.setDisable(true);
            assessmentContentTextArea.setText(null);

            initialDatePicker.setDisable(true);
            initialDatePicker.setValue(null);
        }

    }

    @FXML
    void createNewAssessment(ActionEvent event) {
        //TODO create a create new assessment pane and implement it
    }

    @FXML
    void deleteAssessment(ActionEvent event) {
        Workshop assessment = assessmentsTableView.getSelectionModel().getSelectedItem();
        if (selectedCourse.getActivities().remove(assessment)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Operación exitosa");
            alert.setHeaderText("Taller eliminado");
            alert.setContentText("El taller ha sido eliminado existosamente. Presione OK");
            alert.showAndWait();

        }
    }

    @FXML
    void exportAssessmentsList(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setInitialFileName("Reporte-Talleres.csv");

        //Show save file dialog

        File file = fileChooser.showSaveDialog((Stage)((Node)event.getSource()).getScene().getWindow());

        if (file != null) {

        }
    }

    @FXML
    void importAssessmentsList(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showOpenDialog((Stage)((Node)event.getSource()).getScene().getWindow());

        if (file != null) {

        }
    }

    @FXML
    void refreshCourses(MouseEvent event) {
        initializeComboBox();
    }

    @FXML
    void showAssessmentInfo(MouseEvent event) {
        Workshop assessment = assessmentsTableView.getSelectionModel().getSelectedItem();
        if (assessment != null) {
            assessmentNameTextField.setDisable(false);
            assessmentNameTextField.setText(assessment.getTopic());

            assessmentPercentageTextField.setDisable(false);
            assessmentPercentageTextField.setText(assessment.getPercentage() + "%");

            assessmentContentTextArea.setDisable(false);
            assessmentContentTextArea.setText(assessment.getContent());

            initialDatePicker.setDisable(false);
            initialDatePicker.setValue(assessment.getAssignmentDate());
        }
    }

    @FXML
    void showAssessments(ActionEvent event) {
        selectedCourse = coursesComboBox.getSelectionModel().getSelectedItem();
        initializeAssessmentTableView();
    }
}
