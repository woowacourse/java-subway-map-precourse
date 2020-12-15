package subway.view;

import subway.screen.MainScreen;
import subway.screen.StationScreen;

public class Output {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String RESULT_PREFIX = "[INFO] ";
	
    private MainScreen main;
    private StationScreen station;
	
    public Output() {
        main = new MainScreen();
        station = new StationScreen();
    }
    
    public void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
	}
	
    public void printResult(String message) {
        System.out.println(RESULT_PREFIX + message);
    }
		
    public void printMainMenu() {
        main.printScreen();
    }   
    
    public void printStationMenu() {
    	station.printScreen();
    }
}