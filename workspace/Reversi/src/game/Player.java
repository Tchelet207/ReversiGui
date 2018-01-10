package game;

import java.util.ArrayList;
/*
 * Naama Harshoshanim
 * 315783217
 * Tchelet Englman
 * 208780585
 */
public interface Player {
	/**
     * choosing cell from the vector of the optional cells.
     * @param options
     * @return Point
     */
	Point chooseCell(ArrayList<Point> options);
	/**
     * get the member cellType1.
     * @return cellType
     */
    Celltype getCellType();
    /**
     * get the member name.
     * @return string
     */
    String getName();
}