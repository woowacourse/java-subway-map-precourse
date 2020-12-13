package subway.view;

public class OutputView {
    private static final String SHARP_PREFIX = "## ";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String INFO_PREFIX = "[INFO] ";
    private static final String STATION_SUFFIX = " 역";

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
}
