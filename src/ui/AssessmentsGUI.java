package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.EvaluationSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AssessmentsGUI {

    private EvaluationSystem evaluationSystem;

    @FXML
    private TableView<AssessmentsGUI> assessmentsTableView;

    @FXML
    private TableColumn<AssessmentsGUI, String> tcAssessmentsName;

    @FXML
    private TableColumn<AssessmentsGUI, String> tcAssessmentsPercentage;

    @FXML
    private TableColumn<AssessmentsGUI, String> tcAssessmentsInitialDate;

    @FXML
    private TableColumn<AssessmentsGUI, String> tcAssessmentsFinalDate;

    @FXML
    private TextField assessmentNameTextField;

    @FXML
    private TextField assessmentPercentageTextField;

    @FXML
    private TextArea assessmentContentTextArea;

    @FXML
    private DatePicker finalDatePicker;

    @FXML
    private DatePicker initialDatePicker;

    @FXML
    private ChoiceBox<?> coursesChoiceBox;

    public AssessmentsGUI(EvaluationSystem evaluationSystem) {
        this.evaluationSystem = evaluationSystem;
    }

    private void initializeAssessmentTableView () {

    }

    @FXML
    void checkAnswers(ActionEvent event) {

    }

    @FXML
    void cleanList(ActionEvent event) {

    }

    @FXML
    void createNewAssessment(ActionEvent event) {

    }

    @FXML
    void deleteAssessment(ActionEvent event) {

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
    void showAssessmentInfo(MouseEvent event) {

    }

    @FXML
    void showAssessments(MouseEvent event) {

    }
}
