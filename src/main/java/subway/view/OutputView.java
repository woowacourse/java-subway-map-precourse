package subway.view;

import subway.domain.Line.Line;
import subway.domain.station.Station;
import subway.menu.Menu;

import java.util.List;

public class OutputView {

    private static final String INFO_PREFIX = "[INFO] ";
    private static final String INPUT_PREFIX = "## ";
    private static final String PRINT_STATIONS_TITLE = INPUT_PREFIX + "역목록";
    private static final String PRINT_LINES_TITLE = INPUT_PREFIX + "노선 목록";
    private static final String MENU_SUFFIX = "화면";

    private static void addBlankLine() {
        System.out.println();
    }

    public static void printStations(final List<Station> stations) {

        System.out.println(PRINT_STATIONS_TITLE);
        for (Station station : stations) {
            System.out.println(INFO_PREFIX + station.toString());
        }
        addBlankLine();
    }

    public static void printLines(final List<Line> lines) {

        System.out.println(PRINT_LINES_TITLE);
        for (Line line : lines) {
            System.out.println(INFO_PREFIX + line.toString());
        }
        addBlankLine();
    }

    public static void printMenu(Menu menu) {
        System.out.println(INPUT_PREFIX + menu.getTitle() + MENU_SUFFIX);
        for (Menu value : menu.getValues()) {
            System.out.println(value.toString());
        }
        addBlankLine();
    }

}
