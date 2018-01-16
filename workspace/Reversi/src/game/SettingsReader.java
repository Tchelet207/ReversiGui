package game;
import java.io.BufferedReader;
import java.io.IOException;

import game.GameSettings;
import javafx.scene.paint.Color;

public class SettingsReader {
	/**
	 * reading the file and return GameSettings.
	 * @param reader
	 * @return GameSettings
	 */
	public static GameSettings fromReader(BufferedReader bufferReader) {
		//BufferedReader bufferReader = new BufferedReader(reader);
		Color openingColor = null;
		Color player1 = null;
		Color player2 = null;
    	String sizeString = null;
    	int boardSize = 0;
        try {
        	String str = bufferReader.readLine();
            openingColor = convertFromStringToColor(str);
            str = bufferReader.readLine();
        	player1 = convertFromStringToColor(str);
        	str = bufferReader.readLine();
            player2 = convertFromStringToColor(str);
        	sizeString = bufferReader.readLine();
        	boardSize = Integer.valueOf(sizeString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        GameSettings settings = new GameSettings(openingColor, player1, player2, boardSize);
        return settings;
	}
	
	public static Color convertFromStringToColor(String color) {
		switch (color) {
			case "black":
				return Color.BLACK;
			case "white":
				return Color.WHITE;
			case "pink":
				return Color.PINK;
			case "red":
				return Color.RED;
			case "blue":
				return Color.BLUE;
			case "green":
				return Color.GREEN;
			case "yellow":
				return Color.YELLOW;
			case "purple":
				return Color.PURPLE;
			default:
				return null;
		}
	}
}
