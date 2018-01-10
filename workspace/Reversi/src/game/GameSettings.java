package game;

public class GameSettings {
	private String openingColor;
	private String player1;
	private String player2;
	private int boardSize;
	/**
	 * constructor.
	 * @param oc    openingColor
	 * @param p1    player1
	 * @param p2    player2
	 * @param bs    boardSize
	 */
	public GameSettings(String oc, String p1, String p2, int bs) {
		this.boardSize = bs;
		this.openingColor = oc;
		this.player1 = p1;
		this.player2 = p2;
	}
	/**
	 * getting openingColor.
	 * @return openingColor
	 */
	public String getOpeningColor() {
		return this.openingColor;
	}
	/**
	 * getting player1.
	 * @return player1
	 */
	public String getPlayer1() {
		return this.player1;
	}
	/**
	 * getting player2.
	 * @return player2
	 */
	public String getPlayer2() {
		return this.player2;
	}
	/**
	 * getting boardSize.
	 * @return boardSize
	 */
	public int getSize() {
		return this.boardSize;
	}
}
