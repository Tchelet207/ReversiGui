package game;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/*
 * Naama Harshoshanim
 * 315783217
 * Tchelet Englman
 * 208780585
 */
public class MenuController {
	@FXML
	private Button startButton;
	@FXML
	private Button settingButton;
	/**
	 * starting game.
	 */
	@FXML
	public void startingGame() {
		Stage stage = (Stage) this.startButton.getScene().getWindow();
		stage.close();
		GameMain gameMenu = new GameMain();
		gameMenu.start(stage);
	}
	/**
	 * choose setting.
	 */
	@FXML
	public void chooseSettings() {
		Stage stage = (Stage) this.settingButton.getScene().getWindow();
		stage.close();
		Settings s = new Settings();
		s.start(stage);
	}
}
