package subway.view;

import java.util.List;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.menu.Menu;
import subway.domain.menu.MenuItem;
import subway.view.messageparts.ActionParts;
import subway.view.messageparts.InformPredicateParts;
import subway.view.messageparts.InformSubjectParts;
import subway.view.messageparts.ObjectParts;

public class OutputView {
    private static final String MESSAGE_FORMAT = "## %s%n";
    private static final String INFORM_FORMAT = "[INFO] %s%n";
    private static final String ERROR_FORMAT = "[ERROR] %s%n";
    private static final String MENU_ITEM_FORMAT = "%s. %s%n";

    private static final String REQUEST_SELECT_FUNCTION = "원하는 기능을 선택하세요.";
    private static final String REQUEST_INPUT_FORMAT = "%s입력하세요.";

    protected static final String STATION_LIST = "역 목록";
    protected static final String LINE_LIST = "노선 목록";
    private static final String SUBWAY_MAP = "지하철 노선도";
    private static final String SEPARATOR = "---";

    public static void printMenu(Menu menu) {
        printMessage(menu.getTitle());
        for (MenuItem menuItem : menu) {
            printMenuItem(menuItem);
        }
    }

    private static void printMenuItem(MenuItem menuItem) {
        System.out.printf(MENU_ITEM_FORMAT, menuItem.getKey(), menuItem.getName());
    }

    public static void requestSelectFunction() {
        printMessage(REQUEST_SELECT_FUNCTION);
    }

    public static void printSubwayMap() {
        printMessage(SUBWAY_MAP);
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            printSubwayLine(line);
            printEmptyLine();
        }
    }

    private static void printSubwayLine(Line line) {
        printListItem(line.getName());
        printListItem(SEPARATOR);
        for (String station : line) {
            printListItem(station);
        }
    }

    public static void printError(Exception exception) {
        printEmptyLine();
        System.out.printf(ERROR_FORMAT, exception.getMessage());
    }

    protected static void printMessage(String message) {
        printEmptyLine();
        System.out.printf(MESSAGE_FORMAT, message);
    }

    protected static void printInformMessage(String informnation) {
        printEmptyLine();
        System.out.printf(INFORM_FORMAT, informnation);
    }

    protected static void printListItem(String listItem) {
        System.out.printf(INFORM_FORMAT, listItem);
    }

    private static void printEmptyLine() {
        System.out.println();
    }

    protected static String getRequestMessage(ActionParts action, ObjectParts object) {
        return String.format(REQUEST_INPUT_FORMAT, action.toString() + object.toString());
    }

    protected static String getInformMessage(InformSubjectParts subject, InformPredicateParts predicate) {
        return (subject.toString() + predicate.toString());
    }
}
