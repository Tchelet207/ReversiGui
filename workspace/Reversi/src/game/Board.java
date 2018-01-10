package game;

import java.util.ArrayList;
/*
 * Naama Harshoshanim
 * 315783217
 * Tchelet Englman
 * 208780585
 */
public interface Board {
    /*
     * printing the board.
     */
	void printBoard();
    /**
     * checking if the board is full.
     * @return boolean
     */
    boolean ifFull();
    /**
     * checking who wins.
     * @return cellType
     */
    Celltype whoWins();
    /**
     * returning the board.
     * @return cellType**
     */
    ArrayList<ArrayList<Celltype>> getBoard();
    /**
     * returning the size.
     * @return int
     */
    int getSize();
	/**
	 * return the x counter.
	 * @return xcounter
	 */
	int getXCounter();

	/**
	 * return the o counter.
	 * @return ocounter
	 */
	int getOCounter();

	/**
	 * set the x counter.
	 * @param newXcounter
	 */
	void setXCounter(int newXcounter);

	/**
	 * set the o counter.
	 * @param newOcounter
	 */
	void setOCounter(int newOcounter);
}
