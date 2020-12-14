package subway.view;

import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.menu.Menu;
import subway.domain.menu.MenuItem;
import subway.view.messageparts.RequestActionParts;
import subway.view.messageparts.InformPredicateParts;
import subway.view.messageparts.InformSubjectParts;
import subway.view.messageparts.RequestObjectParts;

public class OutputView {
    private static final String MESSAGE_FORMAT = "## %s%n";
    private static final String INFORM_FORMAT = "[INFO] %s%n";
    private static final String ERROR_FORMAT = "[ERROR] %s%n";
    private static final String MENU_ITEM_FORMAT = "%s. %s%n";

    private static final String REQUEST_SELECT_FUNCTION = "원하는 기능을 선택하세요.";
    private static final String REQUEST_INPUT_FORMAT = "%s입력하세요.";

    private static final String SUBWAY_MAP = "지하철 노선도";
    private static final String SEPARATOR = "---";

    public static void printMenu(Menu menu) {
        printMessage(menu.getTitle());
        for (MenuItem menuItem : menu) {
            printMenuItem(menuItem);
        }
        printEmptyLine();
    }

    private static void printMenuItem(MenuItem menuItem) {
        System.out.printf(MENU_ITEM_FORMAT, menuItem.getKey(), menuItem.getName());
    }

    public static void requestSelectFunction() {
        printMessage(REQUEST_SELECT_FUNCTION);
    }

    protected static void printList(String title, List<String> listItems) {
        printMessage(title);
        for (String listItem : listItems) {
            printListItem(listItem);
        }

        InputView.waitForEmptyInput();
    }

    private static void printListItem(String listItem) {
        System.out.printf(INFORM_FORMAT, listItem);
    }

    public static void printSubwayMap() {
        printMessage(SUBWAY_MAP);
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            printSubwayLine(line);
            printEmptyLine();
        }

        InputView.waitForEmptyInput();
    }

    private static void printSubwayLine(Line line) {
        printListItem(line.getName());
        printListItem(SEPARATOR);
        for (String station : line) {
            printListItem(station);
        }
    }

    public static void printError(Exception exception) {
        System.out.printf(ERROR_FORMAT, exception.getMessage());
        printEmptyLine();
    }

    protected static void printMessage(String message) {
        System.out.printf(MESSAGE_FORMAT, message);
    }

    protected static void printInformMessage(String informnation) {
        System.out.printf(INFORM_FORMAT, informnation);
        InputView.waitForEmptyInput();
    }
    
    public static void printEmptyLine() {
        System.out.println();
    }

    protected static String getRequestMessage(RequestActionParts action, RequestObjectParts object) {
        return String.format(REQUEST_INPUT_FORMAT, action.toString() + object.toString());
    }

    protected static String getInformMessage(InformSubjectParts subject, InformPredicateParts predicate) {
        return (subject.toString() + predicate.toString());
    }
}
