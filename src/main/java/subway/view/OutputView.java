package subway.view;

import subway.domain.Station;

import java.util.List;

public class OutputView {
    private static final String SHARP_PREFIX = "## ";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String INFO_PREFIX = "[INFO] ";
    private static final String STATION_SUFFIX = " 역";
    private static final String DASH = "---";
    private static final String MENU_SELECT = "원하는 기능을 선택하세요.";

    public static void printMenuMessage(List<String> menuMessages) {
        System.out.print(SHARP_PREFIX);
        menuMessages.forEach(System.out::println);
        System.out.println(SHARP_PREFIX + MENU_SELECT);
    }

    public static void warnMessage(String warnMessage) {
        System.out.println(ERROR_PREFIX + warnMessage);
        System.out.println();
    }

    public static void askMessage(String askMessage) {
        System.out.println(SHARP_PREFIX + askMessage);
    }

    public static void infoMessage(String infoMessage) {
        System.out.println(INFO_PREFIX + infoMessage);
        System.out.println();
    }

    public static void lineDetailPrint(String name, List<Station> stations) {
        System.out.println(INFO_PREFIX + name);
        System.out.println(INFO_PREFIX + DASH);
        stations.forEach(station -> infoMessage(station.getName()));
        System.out.println();
    }
}
