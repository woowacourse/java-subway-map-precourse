package subway.view;

import subway.domain.screen.MainScreen;
import subway.domain.screen.StationManagementScreen;

import java.util.List;

public class OutputView {
    private final static String ERROR_PREFIX = "[ERROR]";
    private final static String INFO_PREFIX = "[INFO]";
    private final static String SPACE = " ";
    private final static String STATION_LIST_TITLE = "## 역 목록";

    public static void showMainScreen() {
        String message = MainScreen.getInstance().toString();
        printGuide(message);
    }

    public static void showStationManagementScreen() {
        String message = StationManagementScreen.getInstance().toString();
        printGuide(message);
    }

    public static void showStationList(List<String> stationNames) {
        printGuide(STATION_LIST_TITLE);
        stationNames.stream()
                .forEach(OutputView::printInfo);
        lineFeed();
    }

    private static void printGuide(String message) {
        println(message);
    }

    private static void printError(String message) {
        println(ERROR_PREFIX + SPACE + message);
    }

    private static void printInfo(String message) {
        println(INFO_PREFIX + SPACE + message);
    }

    private static void print(String message) {
        System.out.print(message);
    }

    private static void println(String message) {
        System.out.println(message);
    }

    private static void lineFeed() {
        System.out.println();
    }
}
