package subway.manager;

import java.util.Scanner;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.Subway;

public class SubwayManager {

    static final String INFO_PREFIX = "[INFO] ";
    static final String ERROR_PREFIX = "[ERROR] ";

    private static Subway subway = new Subway();

    public static void addStation(String stationName) {
        subway.addStation(stationName);
    }

    public static boolean deleteStation(String stationName) {
        return subway.deleteStation(stationName);
    }

    public static boolean deleteLine(String lineName) {
        return subway.deleteLine(lineName);
    }

    public static void printStation() {
        for (Station station : subway.stations()) {
            System.out.println(INFO_PREFIX + station.getName());
        }
        System.out.println();
    }

    public static boolean isDuplicatedStation(String stationName) {
        return subway.isDuplicatedStation(stationName);
    }

    public static void addLine(String lineName, String upwardStationName,
        String downwardStationName) {
        subway.addLine(lineName, upwardStationName, downwardStationName);
    }

    public static boolean isDuplicatedLine(String lineName) {
        return subway.isDuplicatedLine(lineName);
    }

    public static boolean isExistStation(String stationName) {
        for (Station station : subway.stations()) {
            if (station.isSameName(stationName)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isExistLine(String lineName) {
        for (Line line : subway.lines()) {
            if (line.isSameName(lineName)) {
                return true;
            }
        }
        return false;
    }

    public static void printLine() {
        for (Line line : subway.lines()) {
            System.out.println(INFO_PREFIX + line.getName());
        }
        System.out.println();
    }

    public static void addSection(String lineName, String stationName, int order) {
        subway.addSection(lineName, stationName, order);
    }

    public static boolean deleteSection(String lineName, String stationName) {
        return subway.deleteSection(lineName, stationName);
    }

    public static boolean isStationInLine(String name) {
        return subway.isStationInLine(name);
    }

    public void printMap() {
        subway.printMap();
    }
}
