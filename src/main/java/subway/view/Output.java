package subway.view;

import subway.screen.LineScreen;
import subway.screen.MainScreen;
import subway.screen.SectionScreen;
import subway.screen.StationScreen;

public class Output {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String RESULT_PREFIX = "[INFO] ";
	
    private MainScreen main;
    private StationScreen station;
    private LineScreen line;
    private SectionScreen section;
	
    public Output() {
        main = new MainScreen();
        station = new StationScreen();
        line = new LineScreen();
        section = new SectionScreen();
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
    
    public void printLineMenu() {
        line.printScreen();
    }
    
    public void printSectionMenu() {
        section.printScreen();
    }
}