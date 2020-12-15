package subway.view;

import java.util.Scanner;

import subway.screen.Screen;
import subway.screen.StationScreen;

public class Input {
    public static Scanner scanner;
	
    public static String chooseFunction() {
        Screen.chooseFunction();
        return scanner.next();
    }
    
    public static String inputAddStationName() {
        StationScreen.askAddStationName();
	    return scanner.next();
	}
    
    public static String inputDeleteStationName() {
        StationScreen.askDeleteStationName();
        return scanner.next();
    }
}
