package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.EvaluationSystem;
import model.Questionnaire;

import java.io.File;

public class QuestionnairesGUI {

    private EvaluationSystem evaluationSystem;

    @FXML
    private TableView<Questionnaire> questionnairesTableView;

    @FXML
    private TableColumn<Questionnaire, String> tcQuestionnairesName;

    @FXML
    private TableColumn<Questionnaire, String> tcQuestionnairesPercentage;

    @FXML
    private TableColumn<Questionnaire, String> tcInitialDate;

    @FXML
    private TableColumn<Questionnaire, String> tcFinalDate;

    @FXML
    private TableColumn<Questionnaire, String> tcQuestionnairesAttempts;

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

    public QuestionnairesGUI(EvaluationSystem evaluationSystem) {
        this.evaluationSystem = evaluationSystem;
    }

    private void initializeQuestionnaireTableView () {

    }

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
        FileChooser fileChooser = new FileChooser();

        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setInitialFileName("Reporte-Cuestionarios.csv");

        //Show save file dialog

        File file = fileChooser.showSaveDialog((Stage)((Node)event.getSource()).getScene().getWindow());

        if (file != null) {

        }
    }

    @FXML
    void importQuestionnairesList(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showOpenDialog((Stage)((Node)event.getSource()).getScene().getWindow());

        if (file != null) {

        }
    }

    @FXML
    void showQuestionnaireInfo(MouseEvent event) {

    }

    @FXML
    void showQuestionnaires(MouseEvent event) {

    }
}
