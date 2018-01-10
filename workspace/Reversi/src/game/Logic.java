package game;

import java.util.ArrayList;
/*
 * Naama Harshoshanim
 * 315783217
 * Tchelet Englman
 * 208780585
 */
public interface Logic {
	/**
     * finding the optional cells that the player can choose.
     * returning a vector of optional points.
     * @param c
     * @return ArrayList
     */
    public ArrayList findCells(Celltype c);
    /**
     * updating the board after the player chose the cell.
     * @param celltype1
     * @param p
     */
    public void updateBoard(Celltype celltype1, Point p);
    /**
     * checking if the cell is one of the options.
     * @param p
     * @param vec
     * @return boolean
     */
    public boolean ifCellValid(Point p, ArrayList<Point> vec);
    /**
     * get of the member optionalCells
     * @return vector<Point>*
     */
    public ArrayList getOptionalCells();
    /**
     * checking the which cells to change according to the cell that the player chose.
     * @param p
     * @param rowDelta
     * @param columnDelta
     * @param c
     * @return bool
     */
    public boolean checkCells(Point p, int rowDelta, int columnDelta, Celltype c);
    /**
     * changing the cells according to the cell that the player chose.
     * @param p
     * @param rowDelta
     * @param columnDelta
     * @param c
     */
    public void makeMove(Point p, int rowDelta, int columnDelta, Celltype c);
    /**
     * for each empty cell, check if its an optional cell to the player.
     * @param p
     * @param rowDelta
     * @param columnDelta
     * @param c bool
     * @return
     */
    public boolean ifCellAnOption(Point p, int rowDelta, int columnDelta, Celltype c);
    /**
     * checking if the player has more moves.
     * @return bool
     */
    public boolean ifHaveMoreMoves();
}