package game;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * Naama Harshoshanim
 * 315783217
 * Tchelet Englman
 * 208780585
 */
public class Game {
    // members.
    private Board board;
    private Logic logic;
    private Player player1;
    private Player player2;
    
    /**
     * constructor.
     */
	public Game(Board board, Logic logic, Player p1, Player p2) {
	    this.logic = logic;
	    this.board = board;
	    this.player1 = p1;
	    this.player2 = p2;
	}
	
	/**
	 * run the game.
	 */
	public void run() {
	    int playerTrace = 1, ifHaveMove = 0;
	    boolean ifValid;
	    Player player;
	    this.board.printBoard();
	    while (!this.board.ifFull() && ifHaveMove != 2) {
	        ifValid = false;
	        if (playerTrace%2 == 1) {
	            player = this.player1;
	        } else {
	            player = this.player2;
	        }
	        playerTrace++;
	        ArrayList<Point> vec = this.logic.findCells(player.getCellType());
	        if (vec.size() != 0) {
	            ifHaveMove = 0;
	            while (!ifValid) {
	                Point p = player.chooseCell(vec);
	                ifValid = this.logic.ifCellValid(p, vec);
	                if (ifValid) {
	                    this.logic.updateBoard(player.getCellType(), p);
	                    System.out.println("x: " + this.board.getXCounter() + ", o: " + this.board.getOCounter());
	                    this.board.printBoard();
	                    System.out.println(player.getName() + " played (" + p.getX() + "," + p.getY() + ")");
	                } else {
	                	System.out.println("cant choose this cell");
	                    //cout << "cant choose this cell" << endl;
	                }
	            }
	        } else {
	        	System.out.println(player.getName() + ": its your move.");
	        	System.out.println("No possible moves. Play passes back to the other player. Press any key to continue.");
	            //cout << player->getName() << ": its your move." << endl;
	            //cout << "No possible moves. Play passes back to the other player. Press any key to continue." << endl;
	            ifHaveMove++;
	            String in;
	            Scanner sc = new Scanner(System.in);
	            in = sc.nextLine();
	            //cin >> in;
	        }
	        vec.clear();
	    }
	    this.board.printBoard();
	    if ((this.board.whoWins().getColor() == this.board.getP1() && this.player1.getCellType().getColor() == this.board.getP1()) ||
	        (this.board.whoWins().getColor() == this.board.getP2() && this.player1.getCellType().getColor() == this.board.getP2())) {
	        System.out.println(this.player1.getName() + " wins!");
	    	//cout << this->player1->getName() << " wins!" << endl;
	    } else if ((this.board.whoWins().getColor() == this.board.getP1() && this.player2.getCellType().getColor() == this.board.getP1()) ||
	               (this.board.whoWins().getColor() == this.board.getP2() && this.player2.getCellType().getColor() == this.board.getP2())){
	        System.out.println(this.player2.getName() + " wins!");
	    	//cout << this->player2->getName() << " wins!" << endl;
	    } else {
	        System.out.println("its a tie!");
	        //cout << "its a tie!" << endl;
	    }
	}
}