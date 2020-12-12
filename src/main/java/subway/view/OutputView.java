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
        printList(stations);
        addBlankLine();
    }

    private static <T> void printList(List<T> objs) {
        for (T obj : objs) {
            System.out.println(INFO_PREFIX + obj.toString());
        }
    }

    public static void printLines(final List<Line> lines) {

        System.out.println(PRINT_LINES_TITLE);
        printList(lines);
        addBlankLine();
    }

    public static void printMenu(Menu menu) {
        System.out.println(INPUT_PREFIX + menu.getTitle() + MENU_SUFFIX);
        for (Menu value : menu.getValues()) {
            System.out.println(value.toString());
        }
        addBlankLine();
    }

    public static void printMap(final List<Line> lines) {
        System.out.println("## 지하철 노선도");
        for (Line line : lines) {
            printPrefix(line.toString());
            printList(line.getStations());
            addBlankLine();
        }

    }

    private static void printPrefix(String context) {
        System.out.println(INFO_PREFIX + context);
    }
}
