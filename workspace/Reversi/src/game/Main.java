package game;
/*
 * Naama Harshoshanim
 * 315783217
 * Tchelet Englman
 * 208780585
 */

import java.io.InputStreamReader;
import game.GameSettings;
public class Main {
    /**
     * main function.
     * @param args
     */
    public static void main(String[] args) {
    	InputStreamReader r = new InputStreamReader(ClassLoader.getSystemClassLoader()
                .getResourceAsStream("setting.txt"));
    	GameSettings gs = SettingsReader.fromReader(r);
    	Board board = new BoardConsole(gs.getSize(), gs.getPlayer1(), gs.getPlayer2());
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
        Logic standartLogic = new StandartLogic(board);
        Game game = new Game(board, standartLogic, personP1, personP2);
        game.run();
    }
}