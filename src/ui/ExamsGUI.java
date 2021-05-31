package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.EvaluationSystem;
import model.Exam;

import java.io.File;

public class ExamsGUI {

    private EvaluationSystem evaluationSystem;

    @FXML
    private AnchorPane adminPane;

    @FXML
    private TableView<Exam> examsTableView;

    @FXML
    private TableColumn<Exam, String> tcExamsName;

    @FXML
    private TableColumn<Exam, String> tcExamsPercentage;

    @FXML
    private TableColumn<Exam, String> tcExamsFinalDate;

    @FXML
    private TableColumn<Exam, String> tcExamsLimitTime;

    @FXML
    private TextField examNameTextField;

    @FXML
    private TextField examPercentageTextField;

    @FXML
    private TextArea examContentTextArea;

    @FXML
    private DatePicker finalDatePicker;

    @FXML
    private Label labEmployeeId21;

    @FXML
    private TextField examLimitTimeTextField;

    @FXML
    private ChoiceBox<?> coursesChoiceBox;

    public ExamsGUI(EvaluationSystem evaluationSystem) {
        this.evaluationSystem = evaluationSystem;
    }

    @FXML
    void cleanList(ActionEvent event) {

    }

    @FXML
    void createNewExam(ActionEvent event) {

    }

    @FXML
    void deleteExam(ActionEvent event) {

    }

    @FXML
    void exportExamsList(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setInitialFileName("Reporte-Examenes.csv");

        //Show save file dialog

        File file = fileChooser.showSaveDialog((Stage)((Node)event.getSource()).getScene().getWindow());

        if (file != null) {

        }
    }

    @FXML
    void importExamsList(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showOpenDialog((Stage)((Node)event.getSource()).getScene().getWindow());

        if (file != null) {

        }
    }

    @FXML
    void showExamInfo(MouseEvent event) {

    }

    @FXML
    void showExams(MouseEvent event) {

    }
}
