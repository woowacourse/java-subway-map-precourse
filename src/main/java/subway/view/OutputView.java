package subway.view;

import subway.domain.Station;

import java.util.List;

public class OutputView {
    private static final String SHARP_PREFIX = "## ";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String INFO_PREFIX = "[INFO] ";
    private static final String STATION_SUFFIX = " 역";
    private static final String DASH = "---";

    public static void warnMessage(String warnMessage) {
        System.out.println(ERROR_PREFIX + warnMessage);
    }

    public static void askMessage(String askMessage) {
        System.out.print(SHARP_PREFIX + askMessage);
    }

    public static void stationMessage(String stationName) {
        System.out.println(INFO_PREFIX + stationName + STATION_SUFFIX);
    }

    public static void lineMessage(String lineName) {
        System.out.println(INFO_PREFIX + lineName);
    }

    public static void sectionAddMessage(String message) {
        System.out.println(INFO_PREFIX + message);
    }

    public static void sectionDeleteMessage(String message) {
        System.out.println(INFO_PREFIX + message);
    }

    public static void lineDetailPrint(String name, List<Station> stations) {
        System.out.println(INFO_PREFIX + name);
        System.out.println(INFO_PREFIX + DASH);
        stations.forEach(station -> stationMessage(station.getName()));
        System.out.println();
    }
}
