package game;

import javafx.scene.paint.Color;
/*
 * Naama Harshoshanim
 * 315783217
 * Tchelet Englman
 * 208780585
 */
public class Celltype {
	// member:
	private Color status;
	/**
	 * constructor.
	 * @param status1
	 */
	public Celltype(Color status1) {
		this.status = status1;
	}
	/**
	 * set the newStatus to be the status.
	 * @param newStatus
	 */
	public void setCelltype(Color newStatus) {
		this.status = newStatus;
	}
	/**
	 * return the celltype.
	 * @return celltype
	 */
	public Color getColor() {
		return this.status;
	}
}
