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
	public static GameSettings fromReader(java.io.Reader reader) {
		BufferedReader bufferReader = new BufferedReader(reader);
		Color openingColor = null;
		Color player1 = null;
		Color player2 = null;
    	String sizeString = null;
    	int boardSize = 0;
        try {
        	//String line = ;
        	openingColor = Color.valueOf(bufferReader.readLine());
            //java.lang.reflect.Field field1 = Class.forName("Color").getField(line);
            //openingColor = (Color) field1.get(null);
            //java.lang.reflect.Field field2 = Class.forName("javafx.scene.paint.Color").getField(bufferReader.readLine());
        	player1 = Color.valueOf(bufferReader.readLine());
            //java.lang.reflect.Field field3 = Class.forName("javafx.scene.paint.Color").getField(bufferReader.readLine());
        	player2 = Color.valueOf(bufferReader.readLine());
        	sizeString = bufferReader.readLine();
        	boardSize = Integer.valueOf(sizeString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        GameSettings settings = new GameSettings(openingColor, player1, player2, boardSize);
        return settings;
	}
}
