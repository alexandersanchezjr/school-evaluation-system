package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ExamsGUI {

    @FXML
    private AnchorPane adminPane;

    @FXML
    private TableView<?> examsTableView;

    @FXML
    private TableColumn<?, ?> tcExamsName;

    @FXML
    private TableColumn<?, ?> tcExamsPercentage;

    @FXML
    private TableColumn<?, ?> tcExamsFinalDate;

    @FXML
    private TableColumn<?, ?> tcExamsLimitTime;

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

    }

    @FXML
    void importExamsList(ActionEvent event) {

    }

    @FXML
    void showExamInfo(MouseEvent event) {

    }

    @FXML
    void showExams(MouseEvent event) {

    }
}
