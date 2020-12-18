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
    
    public static void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }
	
    public static void printResult(String message) {
        System.out.println(RESULT_PREFIX + message);
    }
		
    public static void printMenu(Screen screen) {
        screen.printScreen();
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
        StationScreen.printStationListInfoMessage();
        for (Station station : StationRepository.stations()) {
            printResult(station.getName());
        }
    }
    
    public static void printLine() {
        LineScreen.printLineListInfoMessage();
        for (Line line : LineRepository.lines()) {
            printResult(line.getName());
        }
    }

    public static void printStationsOnLine(Line line) {
        for (Station station : line.stations()) {
            System.out.println(station.getName());
        }
    }
}