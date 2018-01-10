package game;
/*
 * Naama Harshoshanim
 * 315783217
 * Tchelet Englman
 * 208780585
 */

public class Main {
    /**
     * main function.
     * @param args
     */
    public static void main(String[] args) {
    	Board board = new BoardConsole(4);
    	Celltype black = new Celltype("Black");
    	Celltype white = new Celltype("White");
        PersonP personP1 = new PersonP("X" ,black);
        PersonP personP2 = new PersonP("O" ,white);
        Logic standartLogic = new StandartLogic(board);
        Game game = new Game(board, standartLogic, personP1, personP2);
        game.run();
    }
}