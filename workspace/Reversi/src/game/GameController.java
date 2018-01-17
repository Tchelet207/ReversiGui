package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/*
 * Naama Harshoshanim
 * 315783217
 * Tchelet Englman
 * 208780585
 */
public class GameController implements Initializable {
	@FXML
	private HBox root;
	@FXML
	private Label player1Counter;
	@FXML
	private Label player2Counter;
	@FXML
	private Label playerName;
	@FXML
	private Button backToMenu;
	@Override
	/**
	 * initialize the gameController.
	 * @param location URL
	 * @param resources ResourceBundle
	 */
	public void initialize(URL location, ResourceBundle resources) {
		File file = new File("settings.txt");
		FileReader fileReader;
		InputStreamReader r = null;
		BufferedReader bufferedReader;
		try {
			fileReader = new FileReader("settings.txt");
			bufferedReader = new BufferedReader(fileReader);
		    GameSettings gs = SettingsReader.fromReader(bufferedReader);
		    Board b = new BoardConsole(gs.getSize(), gs.getPlayer1(), gs.getPlayer2());
		    Celltype black = new Celltype(gs.getPlayer1());
		    Celltype white = new Celltype(gs.getPlayer2());
		    PersonP personP1;
		    PersonP personP2;
		    if (gs.getOpeningColor() == gs.getPlayer2()) {
		    	personP1 = new PersonP(nameOf(white.getColor()),white);
		    	personP2 = new PersonP(nameOf(black.getColor()),black);
		    } else {
		    	personP1 = new PersonP(nameOf(black.getColor()),black);
		    	personP2 = new PersonP(nameOf(white.getColor()),white);
		    }
		    Logic standartLogic = new StandartLogic(b);
			BoardController board = new BoardController(b, standartLogic, personP1, personP2, this);
			board.setPrefWidth(400);
			board.setPrefHeight(400);
			root.getChildren().add(0, board);
		    setPlayerCounter("Current player :" + personP1.getName(), "player 1: " + b.getXCounter(), "player 2: " + b.getOCounter());
		    board.draw();
		    bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * set player counter.
	 * @param name String
	 * @param counter1 String
	 * @param counter2 String
	 */
	public void setPlayerCounter(String name, String counter1, String counter2) {
		this.playerName.setText(name);
		this.player1Counter.setText(counter1);
		this.player2Counter.setText(counter2);
	}
	/**
	 * back to the menu.
	 */
	@FXML
	protected void backMenu() {
		Stage s = (Stage) this.backToMenu.getScene().getWindow();
		s.close();
		Menu menu = new Menu();
		menu.start(s);
	}
	/**
	 * casting the color to his name.
	 * @param color Color
	 * @return String
	 */
	public String nameOf(Color color) {
		if (color == Color.BLACK) {
			return "black";
		} else if (color == Color.WHITE) {
			return "white";
		} else if (color == Color.PINK) {
			return "pink";
		} else if (color == Color.RED) {
			return "red";
		} else if (color == Color.BLUE) {
			return "blue";
		} else if (color == Color.GREEN) {
			return "green";
		} else if (color == Color.YELLOW) {
			return "yellow";
		} else if (color == Color.PURPLE) {
			return "purple";
		}
		return "";
	}
}