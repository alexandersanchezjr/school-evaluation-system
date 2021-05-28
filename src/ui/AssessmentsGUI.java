package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class AssessmentsGUI {

    @FXML
    private TableView<?> assessmentsTableView;

    @FXML
    private TableColumn<?, ?> tcAssessmentsName;

    @FXML
    private TableColumn<?, ?> tcAssessmentsPercentage;

    @FXML
    private TableColumn<?, ?> tcAssessmentsInitialDate;

    @FXML
    private TableColumn<?, ?> tcAssessmentsFinalDate;

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

    }

    @FXML
    void importAssessmentsList(ActionEvent event) {

    }

    @FXML
    void showAssessmentInfo(MouseEvent event) {

    }

    @FXML
    void showAssessments(MouseEvent event) {

    }
}
