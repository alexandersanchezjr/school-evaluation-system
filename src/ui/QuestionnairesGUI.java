package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Activity;
import model.Course;
import model.EvaluationSystem;
import model.Questionnaire;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class QuestionnairesGUI {

    private NewQuestionnaireGUI newQuestionnaireGUI;
    private EvaluationSystem evaluationSystem;
    private Course currentCourse;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TableView<Questionnaire> questionnairesTableView;

    @FXML
    private TableColumn<Questionnaire, String> tcQuestionnairesName;

    @FXML
    private TableColumn<Questionnaire, String> tcQuestionnairesPercentage;

    @FXML
    private TableColumn<Questionnaire, String> tcInitialDate;

    @FXML
    private TableColumn<Questionnaire, String> tcQuestionnairesAttempts;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField percentageTextField;

    @FXML
    private TextArea questionnaireContentTextArea;

    @FXML
    private Spinner<Integer> attemptsSpinner;

    @FXML
    private DatePicker initialDatePicker;

    @FXML
    private ComboBox<Course> coursesComboBox;

    public QuestionnairesGUI(EvaluationSystem es) {
        evaluationSystem = es;
        newQuestionnaireGUI = new NewQuestionnaireGUI();
    }

    private void initializeQuestionnaireTableView () {

        ObservableList<Questionnaire> list = FXCollections.observableArrayList(currentCourse.getQuestionnaires());
        questionnairesTableView.setItems(list);
        tcQuestionnairesName.setCellValueFactory(new PropertyValueFactory<Questionnaire, String>("topic"));
        tcQuestionnairesPercentage.setCellValueFactory(new PropertyValueFactory<Questionnaire, String>("percentage"));
        tcInitialDate.setCellValueFactory(new PropertyValueFactory<Questionnaire, String>("assignmentDate"));
        tcQuestionnairesAttempts.setCellValueFactory(new PropertyValueFactory<Questionnaire, String>("attempts"));
        questionnairesTableView.refresh();
    }


    @FXML
    void cleanList(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Confirme borrado de datos");
        dialog.setHeaderText("Por favor, escriba 'SI' si desea limpiar la lista de cuestionarios ");

        // Traditional way to get the response value.
        String input = "";
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            input = result.get();
        }
        if (input.equals("SI")) {
            currentCourse.cleanQuestionnaire();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Operación exitosa");
            alert.setHeaderText("Lista de cuestionarios eliminada");
            alert.setContentText("Todos los cuestionarios han sido borrados existosamente. Presione OK");
            alert.showAndWait();

            initializeQuestionnaireTableView();
            nameTextField.setDisable(true);
            nameTextField.setText(null);

            percentageTextField.setDisable(true);
            percentageTextField.setText(null);

            questionnaireContentTextArea.setDisable(true);
            questionnaireContentTextArea.setText(null);

            initialDatePicker.setDisable(true);
            initialDatePicker.setValue(null);

            attemptsSpinner.setDisable(true);
            attemptsSpinner.setValueFactory(null);
        }

    }

    @FXML
    void createNewQuestionnaire(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/new-questionnaire-pane.fxml"));

        fxmlLoader.setController(newQuestionnaireGUI);
        Parent newQuestionnairePane = null;
        try {
            newQuestionnairePane = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainPane.getChildren().setAll(newQuestionnairePane);
        AnchorPane.setTopAnchor(newQuestionnairePane, 0.0);
        AnchorPane.setBottomAnchor(newQuestionnairePane, 0.0);
        AnchorPane.setLeftAnchor(newQuestionnairePane, 0.0);
        AnchorPane.setRightAnchor(newQuestionnairePane, 0.0);
    }

    @FXML
    void deleteQuestionnaire(ActionEvent event) {
        Questionnaire questionnaire = questionnairesTableView.getSelectionModel().getSelectedItem();

        if (questionnaire != null){
            if (currentCourse.deleteQuestionnaire(questionnaire)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Operación exitosa");
                alert.setHeaderText("Cuestionario eliminado");
                alert.setContentText("El cuestionario ha sido eliminado existosamente. Presione OK");
                alert.showAndWait();
            }

        }
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
            //TODO implement the export questionnaire method.
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
            String separator = ";";
            try {
                currentCourse.importQuestionnaires(file.getAbsolutePath(), separator);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void refreshCourses(MouseEvent event) {
        initializeCourses();
    }

    private void initializeCourses() {
        ArrayList<Course> courses = evaluationSystem.getLogged().getCourses();
        ObservableList<Course> list = FXCollections.observableArrayList(courses);
        if (list != null) {
            coursesComboBox.setItems(list);
        }
    }

    @FXML
    void showQuestionnaireInfo(MouseEvent event) {
        Questionnaire questionnaire = questionnairesTableView.getSelectionModel().getSelectedItem();
        if (questionnaire != null) {
            //Set Topic
            nameTextField.setDisable(false);
            nameTextField.setText(questionnaire.getTopic());
            //Set percentage
            percentageTextField.setDisable(false);
            percentageTextField.setText(questionnaire.getPercentage() + "%");
            //Set initial date
            initialDatePicker.setDisable(false);
            initialDatePicker.setValue(questionnaire.getAssignmentDate());
            //Set attempts
            attemptsSpinner.setDisable(false);
            attemptsSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, questionnaire.getAttempts()));
            //Set content
            questionnaireContentTextArea.setDisable(false);
            questionnaireContentTextArea.setText(questionnaire.getContent());
        }else {
            //Disable the objects
            nameTextField.setDisable(true);
            percentageTextField.setDisable(true);
            initialDatePicker.setDisable(true);
            attemptsSpinner.setDisable(true);
            questionnaireContentTextArea.setDisable(true);

        }
    }

    @FXML
    void showQuestionnaires(ActionEvent event) {
        currentCourse = coursesComboBox.getSelectionModel().getSelectedItem();
        initializeQuestionnaireTableView();
    }
}
