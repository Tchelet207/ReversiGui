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
import javafx.stage.Stage;

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
		    	personP1 = new PersonP("O" ,white);
		    	personP2 = new PersonP("X" ,black);
		    } else {
		    	personP1 = new PersonP("X" ,black);
		    	personP2 = new PersonP("O" ,white);
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
	
	public void setPlayerCounter(String name, String counter1, String counter2) {
		this.playerName.setText(name);
		this.player1Counter.setText(counter1);
		this.player2Counter.setText(counter2);
	}
	
	@FXML
	protected void backMenu() {
		Stage s = (Stage) this.backToMenu.getScene().getWindow();
		s.close();
		Menu menu = new Menu();
		menu.start(s);
	}
}
