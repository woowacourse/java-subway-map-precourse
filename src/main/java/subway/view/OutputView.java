package subway.view;

import subway.domain.Line.Line;
import subway.domain.station.Station;
import subway.menu.Menu;

import java.util.List;

import static subway.view.OutputViewMessage.*;

public class OutputView {

    private static void addBlankLine() {
        System.out.println();
    }

    private static <T> void printList(final List<T> objs) {
        for (T obj : objs) {
            System.out.println(OutputViewMessage.INFO_PREFIX + obj.toString());
        }
    }

    public static void printStations(final List<Station> stations, Menu menu) {
        System.out.println(String.format(PRINT_STATIONS_TITLE, menu.getType()));
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

        String message = String.format(RESULT_MESSAGE, menu.getType(), menu.getAction());
        System.out.println(message);
    }

    public static void printInputMessage(final Menu menu) {
        String message = String.format(ACTION_PRINT_MESSAGE, menu.getAction(), menu.getType());
        System.out.println(message);
    }

    public static void printListTitle(final Menu menu) {
        String message = String.format(LIST_TITLE_MESSAGE, menu.getType());
        System.out.println(message);
    }

    public static void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

}
