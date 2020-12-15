package subway.view;

import java.util.List;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class OutputView {

    private static final String STATION_VIEW_LABEL = "## 역 목록";
    private static final String LINE_VIEW_LABEL = "## 노선 목록";
    private static final String SHOW_MAP_LABEL = "## 지하철 노선도";
    public static final String DIVIDER = "---";

    public static void printMainMenu() {
        printMenu(MenuMessage.mainMenuOptions);
    }

    public static void printStationMenu() {
        printMenu(MenuMessage.stationMenuOptions);
    }

    public static void printLineMenu() {
        printMenu(MenuMessage.lineMenuOptions);
    }

    public static void printSectionMenu() {
        printMenu(MenuMessage.sectionMenuOptions);
    }

    private static void printMenu(List<String> menuOptions) {
        System.out.println();
        menuOptions.forEach(System.out::println);
    }

    public static void printStations() {
        System.out.println();
        System.out.println(STATION_VIEW_LABEL);
        StationRepository.stations().stream()
                .map(Station::getName)
                .map(stationName -> InfoMessage.LABEL + stationName)
                .forEach(System.out::println);
    }

    public static void printLines() {
        System.out.println();
        System.out.println(LINE_VIEW_LABEL);
        LineRepository.lines().stream()
                .map(Line::getName)
                .map(line -> InfoMessage.LABEL + line)
                .forEach(System.out::println);
    }

    public static void printMap() {
        System.out.println();
        System.out.println(SHOW_MAP_LABEL);
        LineRepository.lines().forEach(line -> {
            System.out.println(InfoMessage.LABEL + line.getName());
            System.out.println(InfoMessage.LABEL + DIVIDER);
            printStationsOfLine(line);
            System.out.println();
        });
    }

    private static void printStationsOfLine(Line line) {
        line.getStations()
                .forEach(station -> System.out.println(InfoMessage.LABEL + station.getName()));
    }

    public static void printError(Exception e) {
        System.out.println();
        System.out.println(e.getMessage());
    }

    public static void printInfo(String info) {
        System.out.println();
        System.out.println(info);
    }
}
