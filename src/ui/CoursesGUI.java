package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Course;
import model.EvaluationSystem;

import java.io.File;

public class CoursesGUI {


    private EvaluationSystem evaluationSystem;

    @FXML
    private TableView<Course> studentsTableView;

    @FXML
    private TableColumn<Course, String> tcStudentName;

    @FXML
    private TableColumn<Course, String> tcStudentSurname;

    @FXML
    private TableColumn<Course, String> tcStudentCode;

    @FXML
    private TableColumn<Course, String> tcStudentEmail;

    @FXML
    private TextField studentNameTextField;

    @FXML
    private TextField studentSurnameTextField;

    @FXML
    private TextField studentCodeTextField;

    @FXML
    private TextField studentEmailTextField;

    @FXML
    private TextField studentGradeTextField;

    @FXML
    private Button updateStudentButton;

    @FXML
    private Button updatePhotoButton;

    @FXML
    private ImageView studentPhoto;

    @FXML
    private Label courseNameLabel;

    @FXML
    private ImageView newStudentPhoto;

    @FXML
    private TextField newStudentName;

    @FXML
    private TextField newStudentSurname;

    @FXML
    private TextField newStudentCode;

    @FXML
    private TextField newStudentEmail;

    public CoursesGUI(EvaluationSystem evaluationSystem) {
        this.evaluationSystem = evaluationSystem;
    }

    private void initializeCoursesTableView () {

    }

    @FXML
    void chooseNewPhoto(ActionEvent event) {

    }

    @FXML
    void cleanList(ActionEvent event) {

    }

    @FXML
    void createNewStudent(ActionEvent event) {

    }

    @FXML
    void deleteStudent(ActionEvent event) {

    }

    @FXML
    void exportStudentsList(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setInitialFileName("Reporte-Estudiantes.csv");

        //Show save file dialog

        File file = fileChooser.showSaveDialog((Stage)((Node)event.getSource()).getScene().getWindow());

        if (file != null) {

        }
    }

    @FXML
    void importStudentsList(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showOpenDialog((Stage)((Node)event.getSource()).getScene().getWindow());

        if (file != null) {

        }
    }

    @FXML
    void showStudentInfo(MouseEvent event) {

    }

    @FXML
    void updateStudent(ActionEvent event) {

    }

    @FXML
    void updateStudentPhoto(ActionEvent event) {

    }
}
