package subway.view;

import subway.domain.Line.Line;
import subway.domain.station.Station;
import subway.menu.Menu;

import java.util.List;

public class OutputView {

    private static final String INFO_PREFIX = "[INFO] ";
    private static final String INPUT_PREFIX = "## ";
    private static final String PRINT_STATIONS_TITLE = INPUT_PREFIX + "%s 목록";
    private static final String MENU_SUFFIX = "화면";
    private static final String RESULT_MESSAGE = INFO_PREFIX + "지하철 %s이 %s 되었습니다.";
    private static final String ACTION_PRINT_MESSAGE = "## %s할 %s 이름을 입력하세요.";
    private static final String LIST_TITLE_MESSAGE = "## %s 목록";
    private static final String SUBWAY_MAP_LIST = INPUT_PREFIX + "지하철 노선도";
    private static String LIST_BOUNDARY = "[INFO] ---";

    private static void addBlankLine() {
        System.out.println();
    }

    private static <T> void printList(final List<T> objs) {
        for (T obj : objs) {
            System.out.println(INFO_PREFIX + obj.toString());
        }
    }

    public static void printStations(final List<Station> stations,Menu menu) {
        System.out.println(String.format(PRINT_STATIONS_TITLE,menu.getType()));
        printList(stations);
    }

    public static void printLines(final List<Line> lines) {
        printList(lines);
    }

    public static void printMenu(Menu menu) {
        addBlankLine();
        System.out.println(INPUT_PREFIX + menu.getTitle() + MENU_SUFFIX);
        for (Menu value : menu.getValues()) {
            System.out.println(value.toString());
        }
        addBlankLine();
    }

    public static void printMap(final List<Line> lines) {
        System.out.println(SUBWAY_MAP_LIST);
        for (Line line : lines) {
            printPrefix(line.toString());
            System.out.println(LIST_BOUNDARY);
            printList(line.getStations());
            addBlankLine();
        }
    }

    private static void printPrefix(String context) {
        System.out.println(INFO_PREFIX + context);
    }

    public static void printResultMessage(final Menu menu) {

        String message = String.format(RESULT_MESSAGE, menu.getType(), menu.getActionType());
        System.out.println(message);
    }

    public static void printInputMessage(final Menu menu) {
        String message = String.format(ACTION_PRINT_MESSAGE, menu.getActionType(), menu.getType());
        System.out.println(message);
    }

    public static void printListTitle(final Menu menu) {
        String message = String.format(LIST_TITLE_MESSAGE, menu.getType());
        System.out.println(message);
    }

    public static void printErrorMessage(Exception exception){
        System.out.println(exception.getMessage());
    }

}
