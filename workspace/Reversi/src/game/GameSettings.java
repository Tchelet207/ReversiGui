package game;

import javafx.scene.paint.Color;

public class GameSettings {
	private Color openingColor;
	private Color player1;
	private Color player2;
	private int boardSize;
	/**
	 * constructor.
	 * @param oc    openingColor
	 * @param p1    player1
	 * @param p2    player2
	 * @param bs    boardSize
	 */
	public GameSettings(Color oc, Color p1, Color p2, int bs) {
		this.boardSize = bs;
		this.openingColor = oc;
		this.player1 = p1;
		this.player2 = p2;
	}
	/**
	 * getting openingColor.
	 * @return openingColor
	 */
	public Color getOpeningColor() {
		return this.openingColor;
	}
	/**
	 * getting player1.
	 * @return player1
	 */
	public Color getPlayer1() {
		return this.player1;
	}
	/**
	 * getting player2.
	 * @return player2
	 */
	public Color getPlayer2() {
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
