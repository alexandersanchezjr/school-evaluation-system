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
    private Label labEmployeeId2;

    @FXML
    private TextField assessmentNameTextField;

    @FXML
    private TextField assessmentPercentageTextField;

    @FXML
    private TextArea assessmentContentTextArea;

    @FXML
    private DatePicker finalDatePicker;

    @FXML
    private Label labEmployeeId21;

    @FXML
    private DatePicker initialDatePicker;

    @FXML
    private ChoiceBox<?> coursesChoiceBox;

    @FXML
    void checkAnswers(ActionEvent event) {

    }

    @FXML
    void cleanQuestionnaires(ActionEvent event) {

    }

    @FXML
    void createNewAssessment(ActionEvent event) {

    }

    @FXML
    void deleteQuestionnaire(ActionEvent event) {

    }

    @FXML
    void exportAssessmentsList(ActionEvent event) {

    }

    @FXML
    void importAssessmentsList(ActionEvent event) {

    }

    @FXML
    void showAssessments(MouseEvent event) {

    }

    @FXML
    void showQuestionnaireInfo(MouseEvent event) {

    }
}
