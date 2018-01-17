package game;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * Naama Harshoshanim
 * 315783217
 * Tchelet Englman
 * 208780585
 */
public class PersonP implements Player {
	//members:
	private String name;
	private Celltype celltype1;
	/**
	 * constructor.
	 */
	public PersonP(String name, Celltype celltype) {
	    this.name = name;
	    this.celltype1 = celltype;
	}
	/**
	 * choose cell.
	 * @param options array of option
	 */
	public Point chooseCell(ArrayList<Point> options) {
		System.out.println(name + ": its your move.");
		System.out.println("Your possible moves: ");
	    for (int i = 0; i < options.size(); i++) {
			System.out.print("(" + options.get(i).getX() + "," + options.get(i).getY() + ")");
	    }
	    System.out.println("");
	    System.out.println("");
	    System.out.println("Please enter your move row col:");
	    int x = 0, y = 0;
	    Scanner sc = new Scanner(System.in);
	    x = sc.nextInt();
	    y = sc.nextInt();
	    Point cell = new Point(x,y);
	    return cell;
	}
	/**
	 * return the celltype
	 * @return celltype
	 */
	public Celltype getCellType() {
	    return this.celltype1;
	}
	/**
	 * return the name
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
}