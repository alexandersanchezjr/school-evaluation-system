package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.EvaluationSystem;

import java.io.*;

public class Main extends Application {

	public final String SYSTEM_FILE_NAME = "data/system.sys";

	private LoginGUI loginGUI;
	private EvaluationSystem evaluationSystem;

	public Main () {
		evaluationSystem = new EvaluationSystem();
		loginGUI = new LoginGUI(evaluationSystem);
		try {
			loadSystemData();
		} catch (IOException e) {
			e.printStackTrace();
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
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/login.fxml"));

		fxmlLoader.setController(loginGUI);

		Parent root = fxmlLoader.load();

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Sistema de Evaluación");
		primaryStage.show();
	}

	public void saveSystemData() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SYSTEM_FILE_NAME));
		oos.writeObject(evaluationSystem);
		oos.close();

	}

	public void loadSystemData() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SYSTEM_FILE_NAME));
		evaluationSystem = (EvaluationSystem) ois.readObject();
		ois.close();

	}

}
