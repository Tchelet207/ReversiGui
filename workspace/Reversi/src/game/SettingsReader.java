package game;
import java.io.BufferedReader;
import java.io.IOException;

import game.GameSettings;

public class SettingsReader {
	/**
	 * reading the file and return GameSettings.
	 * @param reader
	 * @return GameSettings
	 */
	public static GameSettings fromReader(java.io.Reader reader) {
		BufferedReader bufferReader = new BufferedReader(reader);
        String openingColor = null;
    	String player1 = null;
    	String player2 = null;
    	String sizeString = null;
    	int boardSize = 0;
        try {
        	openingColor = bufferReader.readLine();
        	player1 = bufferReader.readLine();
        	player2 = bufferReader.readLine();
        	sizeString = bufferReader.readLine();
        	boardSize = Integer.valueOf(sizeString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        GameSettings settings = new GameSettings(openingColor, player1, player2, boardSize);
        return settings;
	}
}
