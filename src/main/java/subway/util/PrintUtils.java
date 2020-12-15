package subway.util;

import java.util.List;
import java.util.Map;
import subway.controller.Controller;
import subway.domain.Line;
import subway.domain.Station;

public class PrintUtils {

    private static final String TITLE_MENU_HEADER = "## ";
    private static final String INFO_HEADER = "[INFO] ";
    private static final String ERROR_HEADER = "[ERROR] ";
    private static final String MENU_DELIMITER = ". ";
    private static final String MAP_DELIMITER = "---";

    public static void printSubwayMap(List<Line> lineList) {
        for(Line line : lineList) {
            printSerialInfo(line.getName());
            printSerialInfo(MAP_DELIMITER);
            for(Station station : line.getStationList()) {
                printSerialInfo(station.getName());
            }
            printLine();
        }
    }

    public static void printMenu(String title, Map<String, Controller> functionMap) {
        printTitleOrDescription(title);
        for(String key : functionMap.keySet()) {
            printMenuIndex(key, functionMap.get(key).getTitle());
        }
        printTitleOrDescription("원하는 기능을 선택하세요.");
    }

    public static void printTitleOrDescription(String title) {
        printLine();
        System.out.println(TITLE_MENU_HEADER + title);
    }

    public static void printMenuIndex(String key, String content) {
        System.out.println(key + MENU_DELIMITER + content);
    }

    public static void printInfo(String info) {
        printLine();
        System.out.println(INFO_HEADER + info);
    }

    public static void printSerialInfo(String info) {
        System.out.println(INFO_HEADER + info);
    }

    public static void printError(String message) {
        System.out.println(ERROR_HEADER + message);
    }

    public static void printLine() {
        System.out.println();
    }

}
