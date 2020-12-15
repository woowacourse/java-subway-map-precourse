package subway.view;

import subway.screen.MainScreen;
import subway.screen.StationScreen;

public class Output {
    private MainScreen main;
    private StationScreen station;
	
    public Output() {
        main = new MainScreen();
        station = new StationScreen();
    }
		
    public void printMainMenu() {
        main.printScreen();
    }   
    
    public void printStationMenu() {
    	station.printScreen();
    }
}