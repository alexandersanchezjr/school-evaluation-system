package ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.EvaluationSystem;

import java.io.*;

public class Main extends Application {

	public final String EVALUATION_SYSTEM_FILE_NAME = "data/evaluation-system.sys";

	private LoginGUI loginGUI;
	private EvaluationSystem evaluationSystem;

	public Main () {
		evaluationSystem = new EvaluationSystem();
		try {
			loadEvaluationSystemData();
		} catch (IOException e) {
			e.printStackTrace();
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("FileNotFoundException");
			alert.setHeaderText("No se han podido cargar los datos");
			alert.setContentText("El programa no ha encontrado evaluation-system.sys. \n\nInténtelo de nuevo.");
			alert.showAndWait();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * The main entry point for all JavaFX applications.
	 * The start method is called after the init method has returned,
	 * and after the system is ready for the application to begin running.
	 *
	 * <p>
	 * NOTE: This method is called on the JavaFX Application Thread.
	 * </p>
	 *
	 * @param primaryStage the primary stage for this application, onto which
	 *                     the application scene can be set. The primary stage will be embedded in
	 *                     the browser if the application was launched as an applet.
	 *                     Applications may create other stages, if needed, but they will not be
	 *                     primary stages and will not be embedded in the browser.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		Stage window = primaryStage;
		window.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				System.out.println("Closing the window!");
				try {
					saveEvaluationSystemData();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		loginGUI = new LoginGUI(evaluationSystem, primaryStage);

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/login.fxml"));

		fxmlLoader.setController(loginGUI);

		Parent root = fxmlLoader.load();

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Sistema de Evaluación");
		primaryStage.show();
	}

	//Serialization

	public void loadEvaluationSystemData() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(EVALUATION_SYSTEM_FILE_NAME));
		evaluationSystem = (EvaluationSystem)ois.readObject();
		ois.close();
	}

	public void saveEvaluationSystemData() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(EVALUATION_SYSTEM_FILE_NAME));
		oos.writeObject(evaluationSystem);
		oos.close();
	}

}
