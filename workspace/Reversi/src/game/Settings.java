package game;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/*
 * Naama Harshoshanim
 * 315783217
 * Tchelet Englman
 * 208780585
 */
public class Settings extends Application {
	@Override
	/**
	 * start show the stage
	 * @param primaryStage Stage
	 */
	public void start(Stage primaryStage) {
		try {
			GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("SettingsFxml.fxml"));
			Scene scene = new Scene(root, 500, 500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Settings");
			primaryStage.setScene(scene); 
			primaryStage.show();
		} catch (IOException exception) {
		 	throw new RuntimeException(exception);
		}
	}
	/**
	 * main function.
	 * @param args String[]
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
