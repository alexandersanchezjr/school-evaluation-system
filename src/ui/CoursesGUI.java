package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CoursesGUI {


    @FXML
    private TableView<?> studentsTableView;

    @FXML
    private TableColumn<?, ?> tcStudentName;

    @FXML
    private TableColumn<?, ?> tcStudentSurname;

    @FXML
    private TableColumn<?, ?> tcStudentCode;

    @FXML
    private TableColumn<?, ?> tcStudentEmail;

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

    }

    @FXML
    void importStudentsList(ActionEvent event) {

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
