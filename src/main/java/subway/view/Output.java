package subway.view;

import subway.controller.SubwayController;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.screen.LineScreen;
import subway.screen.MainScreen;
import subway.screen.Screen;
import subway.screen.SectionScreen;
import subway.screen.StationScreen;

public class Output {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String RESULT_PREFIX = "[INFO] ";
    private static final String DIVIDING_LINE = "---";
    private static final String SUBWAY_MAP_INFO = "지하철 노선도";
	
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
    
    public void printStationListInfoMessage() {
        station.printStationListInfoMessage();
    }
    
    public void printLineListInfoMessage() {
        line.printLineListInfoMessage();
    }
    
    public static void printSubwayMap() {
        System.out.println();
        System.out.println(Screen.SHARP + SUBWAY_MAP_INFO);
        for (Line line : LineRepository.lines()) {
            System.out.println(line.getName());
            System.out.println(DIVIDING_LINE);
            printStationsOnLine(line);
            System.out.println();
        }
    }
    
    public static void printStation() {
        SubwayController.output.printStationListInfoMessage();
        for (Station station : StationRepository.stations()) {
            SubwayController.output.printResult(station.getName());
        }
    }
    
    public static void printLine() {
        SubwayController.output.printLineListInfoMessage();
        for (Line line : LineRepository.lines()) {
            SubwayController.output.printResult(line.getName());
        }
    }

    public static void printStationsOnLine(Line line) {
        for (Station station : line.stations()) {
            System.out.println(station.getName());
        }
    }
}