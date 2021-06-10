package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

public class CoursesGUI {


    private EvaluationSystem evaluationSystem;
    private Course currentCourse;

    @FXML
    private TableView<Student> studentsTableView;

    @FXML
    private TableColumn<Student, String> tcStudentName;

    @FXML
    private TableColumn<Student, String> tcStudentSurname;

    @FXML
    private TableColumn<Student, String> tcStudentCode;

    @FXML
    private TableColumn<Student, String> tcStudentEmail;

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

    @FXML
    void changeCourseName(InputMethodEvent event) {
        currentCourse.setCourseName(courseNameLabel.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operación Exitosa");
        alert.setHeaderText(null);
        alert.setContentText("El nombre del curso fue cambiado exitosamente.");
        alert.showAndWait();
    }

/*    @FXML
    void chooseNewPhoto(ActionEvent event) {

    }*/

    @FXML
    void cleanList(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Confirme borrado de datos");
        dialog.setHeaderText("Por favor, escriba 'SI' si desea limpiar la lista de estudiantes ");

        // Traditional way to get the response value.
        String input = "";
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            input = result.get();
        }
        if (input.equals("SI")) {
            currentCourse.getStudents().clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Operación exitosa");
            alert.setHeaderText("Lista de estudiantes eliminada");
            alert.setContentText("Todos los estudiantes han sido borrados existosamente. Presione OK");
            alert.showAndWait();

            initializeStudentTableView();
            studentNameTextField.setDisable(true);
            studentNameTextField.setText(null);

            studentSurnameTextField.setDisable(true);
            studentSurnameTextField.setText(null);

            studentCodeTextField.setDisable(true);
            studentCodeTextField.setText(null);

            studentEmailTextField.setDisable(true);
            studentEmailTextField.setText(null);

            studentGradeTextField.setDisable(true);
            studentGradeTextField.setText(null);
        }
    }

    @FXML
    void createNewStudent(ActionEvent event) {
        if(newStudentHasEmptyField()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Campos Vacíos");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, rellene todos los campos para poder crear un estudiante");
            alert.showAndWait();
        }else {
            String name = newStudentName.getText();
            String lastname = newStudentSurname.getText();
            String code = newStudentCode.getText();
            String email = newStudentEmail.getText();

            try {
                if (currentCourse.addStudent(name, lastname, email, code)){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Operación exitosa");
                    alert.setHeaderText("Estudiante creado");
                    alert.setContentText("El estudiante ha sido creado existosamente. Presione OK");
                    alert.showAndWait();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean newStudentHasEmptyField() {
        boolean emptyField = false;
        if (newStudentName.getText().isEmpty())
            emptyField = true;
        if (newStudentSurname.getText().isEmpty())
            emptyField = true;
        if (newStudentCode.getText().isEmpty())
            emptyField = true;
        if (newStudentEmail.getText().isEmpty())
            emptyField = true;

        return emptyField;
    }


    @FXML
    void deleteStudent(ActionEvent event) {
        Student student = studentsTableView.getSelectionModel().getSelectedItem();
        if (currentCourse.getStudents().remove(student)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Operación exitosa");
            alert.setHeaderText("Estudiante eliminado");
            alert.setContentText("El estudiante ha sido eliminado existosamente. Presione OK");
            alert.showAndWait();
        }
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
            String separator = ";";
            try {
                currentCourse.exportStudents(file.getAbsolutePath(), separator);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
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
            String separator = ";";
            try {
                currentCourse.importStudents(file.getAbsolutePath(), separator);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void showStudentInfo(MouseEvent event) {
        Student student = studentsTableView.getSelectionModel().getSelectedItem();
        if (student != null) {
            studentNameTextField.setDisable(false);
            studentNameTextField.setText(student.getName());

            studentSurnameTextField.setDisable(false);
            studentSurnameTextField.setText(student.getLastName());

            studentCodeTextField.setDisable(false);
            studentCodeTextField.setText(student.getCode());

            studentEmailTextField.setDisable(false);
            studentEmailTextField.setText(student.getEmail());

            studentGradeTextField.setDisable(false);
            studentGradeTextField.setText(student.getFinalAverageGrade() + "");
        }else {
            studentNameTextField.setDisable(true);      //Deactivate student name text field
            studentNameTextField.setText(null);

            studentSurnameTextField.setDisable(true);   //Deactivate student lastname text field
            studentSurnameTextField.setText(null);

            studentCodeTextField.setDisable(true);      //Deactivate student code text field
            studentCodeTextField.setText(null);

            studentEmailTextField.setDisable(true);     //Deactivate student email text field
            studentEmailTextField.setText(null);

            studentGradeTextField.setDisable(true);     //Deactivate student grade text field
            studentGradeTextField.setText(null);
        }
    }

    @FXML
    void updateStudent(ActionEvent event) {
        Student student = studentsTableView.getSelectionModel().getSelectedItem();

        if (!isEmptyField()){
            String name = studentNameTextField.getText();
            String lastname = studentSurnameTextField.getText();
            String code = studentCodeTextField.getText();
            String email = studentEmailTextField.getText();
            try {
                currentCourse.updateStudent(student, name, lastname, email, code);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Campos Vacíos");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, rellene todos los campos para poder actualizar un estudiante");
            alert.showAndWait();
        }
    }

    private boolean isEmptyField() {
        boolean emptyField = false;
        if (studentNameTextField.getText().isEmpty()){
            emptyField = true;
        }
        if (studentSurnameTextField.getText().isEmpty()){
            emptyField = true;
        }
        if (studentCodeTextField.getText().isEmpty()){
            emptyField = true;
        }
        if (studentEmailTextField.getText().isEmpty()){
            emptyField = true;
        }
        return emptyField;
    }

/*    @FXML
    void updateStudentPhoto(ActionEvent event) {

    }*/

    public void initialize(Course selectedCourse) {
        currentCourse = selectedCourse;
        courseNameLabel.setText(currentCourse.getCourseName());
        initializeStudentTableView();
    }

    private void initializeStudentTableView() {
        ObservableList<Student> list = FXCollections.observableArrayList(currentCourse.getStudents());

        studentsTableView.setItems(list);
        tcStudentName.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        tcStudentSurname.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));
        tcStudentCode.setCellValueFactory(new PropertyValueFactory<Student, String>("code"));
        tcStudentEmail.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));

        studentsTableView.refresh();

    }
}
