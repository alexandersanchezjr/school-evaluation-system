package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import model.EvaluationSystem;

import java.io.*;

public class Main extends Application {

	private LoginGUI loginGUI;
	private EvaluationSystem evaluationSystem;

	public Main () {
		evaluationSystem = new EvaluationSystem();
		try {
			evaluationSystem.loadEvaluationSystemData(evaluationSystem);
		} catch (IOException e) {
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
		loginGUI = new LoginGUI(evaluationSystem, primaryStage);

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/login.fxml"));

		fxmlLoader.setController(loginGUI);

		Parent root = fxmlLoader.load();

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Sistema de Evaluación");
		primaryStage.show();
	}


}
