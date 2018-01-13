package game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Try extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("My First App");
		Label lbl = new Label("Hello World!");
		lbl.setFont(new Font("Arial", 30));
		Button btn = new Button("Click me");
		btn.setOnAction(event -> {
		lbl.setText("Button clicked!");
		});
		VBox root = new VBox();
		root.getChildren().add(lbl);
		root.getChildren().add(btn);
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
