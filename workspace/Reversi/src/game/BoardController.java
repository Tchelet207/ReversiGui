package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class BoardController extends GridPane {
	private Board board;
	private static final int FREE = 0;
	private static final int WALL = 1;
	private Logic logic;
	private Player player1;
	private Player player2;
	private int playerTrace;
	private int ifHaveMove;
    private boolean ifValid;
    private GameController gameController;
	
	
	public BoardController(Board board, Logic logic, Player p1, Player p2, GameController gameController) {
	    this.logic = logic;
	    this.board = board;
	    this.player1 = p1;
	    this.player2 = p2;
	    this.playerTrace = 1;
		this.ifHaveMove = 0;
		this.gameController = gameController;
	    FXMLLoader fxmlLoader = new
	    FXMLLoader(getClass().getResource("BoardFxml.fxml"));
	    fxmlLoader.setRoot(this);
	    fxmlLoader.setController(this);

	    try {
	        fxmlLoader.load();
	        this.setOnMouseClicked(event-> {
	        	Point p = new Point(((int)(event.getSceneX() / (this.getPrefWidth() / this.board.getSize()) + 1)), 
	        			(int)((event.getSceneY() / (this.getPrefHeight() / this.board.getSize())) + 1));
	        	playOneTurn(p);
	        });
	    } catch (IOException exception) {
	        throw new RuntimeException(exception);
	    }
    }

	public void draw() {
		 this.getChildren().clear();
		 int height = (int)this.getPrefHeight();
		 int width = (int)this.getPrefWidth();
		 int cellHeight = height / board.getSize();
		 int cellWidth = width / board.getSize();
		 for (int i = 0; i < board.getSize(); i++) {
			 for (int j = 0; j < board.getSize(); j++) {
				 Rectangle rect = new Rectangle(cellWidth, cellHeight, Color.WHITE);
				 rect.setStroke(Color.BLACK);
				 this.add(rect, i , j);
				 if (this.board.getBoard().get(i).get(j).getColor() == this.board.getP1()) {
					 Circle c = new Circle(cellWidth/2, this.board.getP1());
					 c.setStroke(Color.BLACK);
					 this.add(c, i, j);
				 } else if (this.board.getBoard().get(i).get(j).getColor() == this.board.getP2()) {
					 Circle c = new Circle(cellWidth/2, this.board.getP2());
					 this.add(c, i, j);
					 c.setStroke(Color.BLACK);
				 }
			 }
		 }
	}
	
	public void playOneTurn(Point p) {
		if (this.board.ifFull() || ifHaveMove == 2) {
			String str;
			if ((this.board.whoWins().getColor() == this.board.getP1() && this.player1.getCellType().getColor() == this.board.getP1()) ||
					(this.board.whoWins().getColor() == this.board.getP2() && this.player1.getCellType().getColor() == this.board.getP2())) {
			    str = this.player1.getName() + " wins!";
			} else if ((this.board.whoWins().getColor() == this.board.getP1() && this.player2.getCellType().getColor() == this.board.getP1()) ||
					(this.board.whoWins().getColor() == this.board.getP2() && this.player2.getCellType().getColor() == this.board.getP2())){
				str = this.player2.getName() + " wins!";
			} else {
				str = "its a tie!";
			}
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Game over!");
			alert.setHeaderText(null);
			alert.setContentText(str);
			alert.showAndWait();
		} else {
			Player player;
			ifValid = false;
	        if (playerTrace%2 == 1) {
	            player = this.player1;
	        } else {
	            player = this.player2;
	        }
	        ArrayList<Point> vec = this.logic.findCells(player.getCellType());
	        if (vec.size() != 0) {
	            ifHaveMove = 0;
	            ifValid = this.logic.ifCellValid(p, vec);
	            if (ifValid) {
	                this.logic.updateBoard(player.getCellType(), p);
	        	    playerTrace++;
	        	    if (playerTrace%2 == 1) {
		        	    this.gameController.setPlayerCounter("Current player :" + player1.getName(), "player 1: " + this.board.getXCounter(), "player 2: " + this.board.getOCounter());
	    	        } else {
		        	    this.gameController.setPlayerCounter("Current player :" + player2.getName(), "player 1: " + this.board.getXCounter(), "player 2: " + this.board.getOCounter());
	    	        }
	                draw();
	                    //System.out.println("x: " + this.board.getXCounter() + ", o: " + this.board.getOCounter());
	                    //this.board.printBoard();
	                    //System.out.println(player.getName() + " played (" + p.getX() + "," + p.getY() + ")");
	            } else {
	                	//System.out.println("cant choose this cell");
	            }
	        } else {
	        	//System.out.println(player.getName() + ": its your move.");
	        	//System.out.println("No possible moves. Play passes back to the other player. Press any key to continue.");
	        	playerTrace++;
	        	ifHaveMove++;
	        }
	        vec.clear();
		}
	}
}
