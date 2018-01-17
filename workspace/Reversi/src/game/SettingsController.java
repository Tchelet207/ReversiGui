package game;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
/*
 * Naama Harshoshanim
 * 315783217
 * Tchelet Englman
 * 208780585
 */
public class SettingsController implements Initializable {
	@FXML
	private ComboBox player1Color;
	@FXML
	private ComboBox player2Color;
	@FXML
	private ComboBox openningPlayer;
	@FXML
	private ComboBox boardSize;
	@FXML
	private Button okKey;
	// members:
	ObservableList<String> player1ColorList =
			FXCollections.observableArrayList("black", "white", "pink", "red", "blue", "green",
					"yellow", "purple");
	ObservableList<String> player2ColorList =
			FXCollections.observableArrayList("black", "white", "pink", "red", "blue", "green",
					"yellow", "purple");
	ObservableList<String> openningPLayerList =
			FXCollections.observableArrayList("1", "2");
	ObservableList<String> boardSizeList =
			FXCollections.observableArrayList("4X4","6X6","8X8","10X10","12X12", "14X14", "16X16", "18X18", "20X20");
	/**
	 * return to the menu and save the setting.
	 */
	@FXML
	protected void pressOkKey() {
		String player1 = this.player1Color.getValue().toString();
		String player2 = this.player2Color.getValue().toString();
		String openningPlayer = this.openningPlayer.getValue().toString();
		String boardSize = this.boardSize.getValue().toString();
		writingToFile(player1, player2, openningPlayer, boardSize);
		// making new menu
		Stage s = (Stage) this.okKey.getScene().getWindow();;
		s.close();
		Menu menu = new Menu();
		menu.start(s);
	}
	/**
	 * writing to file.
	 * @param p1 String
	 * @param p2 String
	 * @param op String
	 * @param bs String
	 */
	private void writingToFile(String p1, String p2, String op, String bs) {
		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("settings.txt"),"utf-8"));
			if (op.equals("1")) {
				writer.write(p1);
		        writer.write('\n');
			} else {
				writer.write(p2);
				writer.write('\n');
			}
			writer.write(p1);
			writer.write('\n');
			writer.write(p2);
			writer.write('\n');
			int end = bs.indexOf('X');
			String boardSize = bs.substring(0,end);
			writer.write(boardSize);
		} catch (IOException e) {
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
			}
		}
	}
	/**
	 * initialize.
	 * @param arg0 URL
	 * @param arg1 ResourceBundle
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.player1Color.setValue("black");
		this.player1Color.setItems(player1ColorList);
		this.player2Color.setValue("white");
		this.player2Color.setItems(player2ColorList);
		this.openningPlayer.setValue("1");
		this.openningPlayer.setItems(openningPLayerList);
		this.boardSize.setValue("8X8");
		this.boardSize.setItems(boardSizeList);
	}
}