package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Course;
import model.EvaluationSystem;
import model.Exam;
import model.Workshop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

public class ExamsGUI {

    private EvaluationSystem evaluationSystem;
    private Course currentCourse;


    @FXML
    private AnchorPane adminPane;

    @FXML
    private TableView<Exam> examsTableView;

    @FXML
    private TableColumn<Exam, String> tcExamsName;

    @FXML
    private TableColumn<Exam, String> tcExamsPercentage;

    @FXML
    private TableColumn<Exam, String> tcExamsLimitTime;

    @FXML
    private TextField examNameTextField;

    @FXML
    private TextField examPercentageTextField;

    @FXML
    private TextArea examContentTextArea;

    @FXML
    private TextField examLimitTimeTextField;

    @FXML
    private Button updateExamButton;

    @FXML
    private ComboBox<Course> coursesComboBox;

    public ExamsGUI(EvaluationSystem evaluationSystem) {
        this.evaluationSystem = evaluationSystem;
    }

    private void initializeExamsTableView () {
        ObservableList<Exam> list = FXCollections.observableArrayList(currentCourse.getExams());
        examsTableView.setItems(list);
        tcExamsName.setCellValueFactory(new PropertyValueFactory<Exam, String>("topic"));
        tcExamsPercentage.setCellValueFactory(new PropertyValueFactory<Exam, String>("percentage"));
        tcExamsLimitTime.setCellValueFactory(new PropertyValueFactory<Exam, String>("timeLimit"));
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
            currentCourse.cleanAssessments();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Operación exitosa");
            alert.setHeaderText("Lista de talleres eliminada");
            alert.setContentText("Todos los talleres han sido borrados existosamente. Presione OK");
            alert.showAndWait();

            initializeExamsTableView();
            examNameTextField.setDisable(true);
            examNameTextField.setText(null);

            examPercentageTextField.setDisable(true);
            examPercentageTextField.setText(null);

            examContentTextArea.setDisable(true);
            examContentTextArea.setText(null);

            examLimitTimeTextField.setDisable(true);
            examLimitTimeTextField.setText( null);
        }
    }

    @FXML
    void createNewExam(ActionEvent event) {
        //TODO create a create-new-exam pane and implement it
    }

    @FXML
    void deleteExam(ActionEvent event) {
        Exam exam = examsTableView.getSelectionModel().getSelectedItem();

        if (currentCourse.getExams().remove(exam)){

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Operación exitosa");
            alert.setHeaderText("Exámen eliminado");
            alert.setContentText("El exámen ha sido eliminado existosamente. Presione OK");
            alert.showAndWait();
        }
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
            String separator = ";";
            try {
                currentCourse.exportExams(file.getAbsolutePath(), separator);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

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
            String separator = ";";
            try {
                currentCourse.importExams(file.getAbsolutePath(), separator);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @FXML
    void refreshCourses(MouseEvent event) {
        initializeExamsTableView();
    }

    @FXML
    void showExamInfo(MouseEvent event) {
        Exam exam = examsTableView.getSelectionModel().getSelectedItem();

        if (exam != null){
            enableAndShow(exam);
        }else {
            disableFields();
        }
    }

    private void disableFields() {
        //Update button
        updateExamButton.setDisable(false);

        //Exam name
        examNameTextField.setDisable(true);
        examNameTextField.setText(null);

        //Exam percentage
        examPercentageTextField.setDisable(true);
        examPercentageTextField.setText(null);

        //Exam content
        examContentTextArea.setDisable(true);
        examContentTextArea.setText(null);

        //Exam limit time
        examLimitTimeTextField.setDisable(true);
        examLimitTimeTextField.setText(null);
    }

    private void enableAndShow(Exam e) {
        //Update button
        updateExamButton.setDisable(false);

        //Exam name
        examNameTextField.setDisable(false);
        examNameTextField.setText(e.getTopic());

        //Exam percentage
        examPercentageTextField.setDisable(false);
        examPercentageTextField.setText(e.getPercentage() + "%");

        //Exam content
        examContentTextArea.setDisable(false);
        examContentTextArea.setText(e.getContent());

        //Exam limit time
        examLimitTimeTextField.setDisable(false);
        examLimitTimeTextField.setText(e.getTimeLimit() + "");
    }

    @FXML
    void showExams(ActionEvent event) {
        currentCourse = coursesComboBox.getSelectionModel().getSelectedItem();
        initializeExamsTableView();
    }

    @FXML
    void updateExam(ActionEvent event) {
        Exam exam = examsTableView.getSelectionModel().getSelectedItem();

        if (!hasEmptyField()){
            String name = examNameTextField.getText();
            int percentage = Integer.parseInt(examPercentageTextField.getText());
            String content = examContentTextArea.getText();
            int timeLimit = Integer.parseInt(examLimitTimeTextField.getText());
            currentCourse.updateExam(exam, name, percentage, content, timeLimit);

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Campos Vacíos");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, rellene todos los campos para poder actualizar un exámen");
            alert.showAndWait();
        }
    }

    private boolean hasEmptyField() {
        boolean emptyField = false;
        if (examNameTextField.getText().isEmpty()){
            emptyField = true;
        }
        if (examPercentageTextField.getText().isEmpty()){
            emptyField = true;
        }
        if (examContentTextArea.getText().isEmpty()){
            emptyField = true;
        }
        if (examLimitTimeTextField.getText().isEmpty()) {
            emptyField = true;
        }
        return emptyField;
    }
}
