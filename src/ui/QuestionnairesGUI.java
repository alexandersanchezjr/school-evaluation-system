package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class QuestionnairesGUI {

    @FXML
    private TableView<?> questionnairesTableView;

    @FXML
    private TableColumn<?, ?> tcQuestionnairesName;

    @FXML
    private TableColumn<?, ?> tcQuestionnairesPercentage;

    @FXML
    private TableColumn<?, ?> tcInitialDate;

    @FXML
    private TableColumn<?, ?> tcFinalDate;

    @FXML
    private TableColumn<?, ?> tcQuestionnairesAttempts;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField percentageTextField;

    @FXML
    private TextArea questionnaireContentTextArea;

    @FXML
    private DatePicker finalDatePicker;

    @FXML
    private Spinner<?> attemptsSpinner;

    @FXML
    private DatePicker initialDatePicker;

    @FXML
    private ChoiceBox<?> coursesChoiceBox;

    @FXML
    void cleanList(ActionEvent event) {

    }

    @FXML
    void createNewQuestionnaire(ActionEvent event) {

    }

    @FXML
    void deleteQuestionnaire(ActionEvent event) {

    }

    @FXML
    void exportQuestionnairesList(ActionEvent event) {

    }

    @FXML
    void importQuestionnairesList(ActionEvent event) {

    }

    @FXML
    void showQuestionnaireInfo(MouseEvent event) {

    }

    @FXML
    void showQuestionnaires(MouseEvent event) {

    }
}
