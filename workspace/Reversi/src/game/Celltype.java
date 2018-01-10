package game;
/*
 * Naama Harshoshanim
 * 315783217
 * Tchelet Englman
 * 208780585
 */
public class Celltype {
	// member:
	private String status;
	/**
	 * constructor.
	 * @param status1
	 */
	public Celltype(String status1) {
		this.status = status1;
	}
	/**
	 * return the celltype.
	 * @return celltype
	 */
	public String getCelltype() {
		return this.status;
	}
	/**
	 * set the newStatus to be the status.
	 * @param newStatus
	 */
	public void setCelltype(String newStatus) {
		this.status = newStatus;
	}
}
