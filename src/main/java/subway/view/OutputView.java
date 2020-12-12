package subway.view;

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

    public static void requestStationNameToAdd() {
        String message = getRequestMessage(ActionParts.TO_ADD, ObjectParts.STATION_NAME);
        printMessage(message);
    }

    public static void informStationAdded() {
        String message = getInformMessage(InformSubjectParts.STATION_IS, InformPredicateParts.ADDED);
        printInformMessage(message);
    }

    public static void printError(Exception exception) {
        printEmptyLine();
        System.out.printf(ERROR_FORMAT, exception.getMessage());
    }

    private static void printMessage(String message) {
        printEmptyLine();
        System.out.printf(MESSAGE_FORMAT, message);
    }

    private static void printInformMessage(String informnation) {
        printEmptyLine();
        System.out.printf(INFORM_FORMAT, informnation);
    }

    private static void printEmptyLine() {
        System.out.println();
    }

    private static String getRequestMessage(ActionParts action, ObjectParts object) {
        return String.format(REQUEST_INPUT_FORMAT, action.toString() + object.toString());
    }

    private static String getInformMessage(InformSubjectParts subject, InformPredicateParts predicate) {
        return (subject.toString() + predicate.toString());
    }
}
