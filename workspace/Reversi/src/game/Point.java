package game;
/*
 * Naama Harshoshanim
 * 315783217
 * Tchelet Englman
 * 208780585
 */
public class Point {
	//members:
	private int x;
	private int y;
	/**
	 * constructor.
	 * @param x x
	 * @param y y
	 */
	public Point(int x, int y) {
	     this.x = x;
	     this.y = y;
	}
	/**
	 * return the x.
	 * @return x
	 */
	public int getX() {
		return this.x;
	}
	/**
	 * return the y
	 * @return y
	 */
	public int getY() {
		return this.y;
	}
	/**
	 * set the x
	 * @param newX
	 */
	public void setX(int newX) {
		this.x = newX;
	}
	/**
	 * set the y
	 * @param newY
	 */
	public void setY(int newY) {
		this.y = newY;
	}
}