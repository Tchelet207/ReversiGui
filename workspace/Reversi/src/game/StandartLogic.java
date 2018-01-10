package game;

import java.util.ArrayList;
/*
 * Naama Harshoshanim
 * 315783217
 * Tchelet Englman
 * 208780585
 */
public class StandartLogic implements Logic {
	// members.
	private ArrayList<Point> optionalCells;
    Board board1;
	/**
	 * constructor.
	 */
    public StandartLogic(Board board) {
	    this.board1 = board;
	}
    
    /**
     * finding the optional cells that the player can choose.
     * returning a vector of optional points.
     * @param c
     * @return ArrayList<Point>*
     */
    public ArrayList<Point> findCells(Celltype c) {
    	ArrayList<Point> vector1 = new ArrayList<Point>();
        for (int i = 0; i < this.board1.getSize(); i++) {
            for (int j = 0; j < this.board1.getSize(); j++) {
                Point p = new Point(i+1, j+1);
                if (this.board1.getBoard().get(i).get(j).getCelltype() == "Empty") {
                    if (this.ifCellAnOption(p, 1, 1, c)) {
                        vector1.add(p);
                    } else if (this.ifCellAnOption(p, 1, 0, c)) {
                        vector1.add(p);
                    } else if (this.ifCellAnOption(p, 1, -1, c)) {
                        vector1.add(p);
                    } else if (this.ifCellAnOption(p, -1, 1, c)) {
                        vector1.add(p);
                    } else if (this.ifCellAnOption(p, -1, 0, c)) {
                        vector1.add(p);
                    } else if (this.ifCellAnOption(p, -1, -1, c)) {
                        vector1.add(p);
                    } else if (this.ifCellAnOption(p, 0, 1, c)) {
                        vector1.add(p);
                    } else if (this.ifCellAnOption(p, 0, -1, c)) {
                        vector1.add(p);
                    }
                }
            }
        }
        return vector1;
    }

    /**
     * checking if the cell is one of the options.
     * @param p Point
     * @param rowDelta int
     * @param columnDelta int
     * @param c Celltype
     * @return boolean
     */
    public boolean ifCellAnOption(Point p, int rowDelta, int columnDelta, Celltype c) {
        int currentRow = p.getX() - 1 + rowDelta;
        int currentColumn = p.getY() - 1 + columnDelta;
        if ((currentColumn >= 0) && (currentRow >= 0) &&
                (currentColumn < this.board1.getSize()) &&
                (currentRow < this.board1.getSize())) {
            while (this.board1.getBoard().get(currentRow).get(currentColumn).getCelltype() != c.getCelltype() &&
            		this.board1.getBoard().get(currentRow).get(currentColumn).getCelltype() != "Empty" &&
                    currentColumn < this.board1.getSize() &&
                    currentRow < this.board1.getSize() &&
                    currentColumn >= 0 &&
                    currentRow >= 0) {
                currentColumn = currentColumn + columnDelta;
                currentRow = currentRow + rowDelta;
                if (currentColumn < this.board1.getSize() &&
                    currentRow < this.board1.getSize() &&
                    currentColumn >= 0 &&
                    currentRow >= 0) {
                    if (this.board1.getBoard().get(currentRow).get(currentColumn).getCelltype() == c.getCelltype()) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }

    /**
     * checking if the cell is one of the options.
     * @param p
     * @param vec
     * @return boolean
     */
    public boolean ifCellValid(Point p, ArrayList<Point> vec) {
        boolean ifValid = false;
        for (int i = 0; i < vec.size(); i++) {
            if ((p.getX() == vec.get(i).getX()) &&
                (p.getY() == vec.get(i).getY())) {
                ifValid = true;
                break;
            }
        }
        return ifValid;
    }

    /**
     * updating the board after the player chose the cell.
     * @param celltype1
     * @param p
     */
    public void updateBoard(Celltype celltype, Point p) {
        if (this.checkCells(p, 1, 0, celltype)) {
            this.makeMove(p, 1, 0, celltype);
        }
        if (this.checkCells(p, 1, 1, celltype)) {
            this.makeMove(p, 1, 1, celltype);
        }
        if (this.checkCells(p, 1, -1, celltype)) {
            this.makeMove(p, 1, -1, celltype);
        }
        if (this.checkCells(p, -1, 0, celltype)) {
            this.makeMove(p, -1, 0, celltype);
        }
        if (this.checkCells(p, -1, 1, celltype)) {
            this.makeMove(p, -1, 1, celltype);
        }
        if (this.checkCells(p, -1, -1, celltype)) {
            this.makeMove(p, -1, -1, celltype);
        }
        if (this.checkCells(p, 0, 1, celltype)) {
            this.makeMove(p, 0, 1, celltype);
        }
        if (this.checkCells(p, 0, -1, celltype)) {
            this.makeMove(p, 0, -1, celltype);
        }
    }

    /**
     * for each empty cell, check if its an optional cell to the player.
     * @param p
     * @param rowDelta
     * @param columnDelta
     * @param c boolean
     * @return options
     */
    public boolean checkCells(Point p, int rowDelta, int coulmnDelta, Celltype c) {
        int currentRow = p.getX() - 1 + rowDelta, currentColunm = p.getY() - 1 + coulmnDelta;
        if (currentColunm >= 0 && currentRow >= 0 &&
            currentColunm < this.board1.getSize() &&
            currentRow < this.board1.getSize()) {
            while (this.board1.getBoard().get(currentRow).get(currentColunm).getCelltype() != c.getCelltype() &&
            		this.board1.getBoard().get(currentRow).get(currentColunm).getCelltype() != "Empty" &&
                   currentColunm < this.board1.getSize() &&
                   currentRow < this.board1.getSize() &&
                   currentColunm >= 0 &&
                   currentRow >= 0) {
                currentColunm = currentColunm + coulmnDelta;
                currentRow = currentRow + rowDelta;
                if (currentColunm < this.board1.getSize() &&
                    currentRow < this.board1.getSize() &&
                    currentColunm >= 0 &&
                    currentRow >= 0) {
                    if (this.board1.getBoard().get(currentRow).get(currentColunm).getCelltype() == c.getCelltype()) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }

    /**
     * make a move
     * @param p Point
     * @param rowDelta int
     * @param columnDelta int
     * @param c celltype
     */
    public void makeMove(Point p, int rowDelta, int columnDelta, Celltype c) {
    	if (c.getCelltype() == "White") {
            this.board1.setOCounter(this.board1.getOCounter() + 1);
        } else if (c.getCelltype() == "Black") {
            this.board1.setXCounter(this.board1.getXCounter() + 1);
        }
        this.board1.getBoard().get(p.getX() - 1).get(p.getY() - 1).setCelltype(c.getCelltype());
        int currentRow = p.getX() - 1 + rowDelta, currentColunm = p.getY() - 1 + columnDelta;
        while (this.board1.getBoard().get(currentRow).get(currentColunm).getCelltype() != c.getCelltype() &&
        		this.board1.getBoard().get(currentRow).get(currentColunm).getCelltype() != "Empty" &&
               currentColunm < this.board1.getSize() &&
               currentRow < this.board1.getSize() &&
               currentColunm >= 0 &&
               currentRow >= 0) {
        	this.board1.getBoard().get(currentRow).get(currentColunm).setCelltype(c.getCelltype());
        	if (c.getCelltype() == "White") {
                this.board1.setOCounter(this.board1.getOCounter() + 1);
                this.board1.setXCounter(this.board1.getXCounter() - 1);
            } else if (c.getCelltype() == "Black") {
                this.board1.setXCounter(this.board1.getXCounter() + 1);
                this.board1.setOCounter(this.board1.getOCounter() - 1);
            }
            currentColunm = currentColunm + columnDelta;
            currentRow = currentRow + rowDelta;
            if (currentColunm > this.board1.getSize() &&
                currentRow > this.board1.getSize() &&
                currentColunm < 0 &&
                currentRow < 0) {
                break;
            }
        }
    }

    /**
     * get of the member optionalCells
     * @return ArrayList<Point>
     */
    public ArrayList<Point> getOptionalCells() {
        return this.optionalCells;
    }

    /**
     * checking if the player has more moves.
     * @return boolean
     */
	public boolean ifHaveMoreMoves() {
	    if (this.optionalCells.size() == 0) {
	        return false;
	    }
	    return true;
	}

}