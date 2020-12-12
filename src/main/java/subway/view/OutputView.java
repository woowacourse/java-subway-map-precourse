package subway.view;

import subway.domain.menu.Menu;
import subway.domain.menu.MenuItem;

public class OutputView {
    private static final String MESSAGE_FORMAT = "## %s%n";
    private static final String ERROR_FORMAT = "[ERROR] %s%n";
    private static final String MENU_ITEM_FORMAT = "%s. %s%n";

    private static final String REQUEST_SELECT_FUNCTION = "원하는 기능을 선택하세요.";

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

    public static void printError(Exception exception) {
        printEmptyLine();
        System.out.printf(ERROR_FORMAT, exception.getMessage());
    }
    
    private static void printMessage(String message) {
        printEmptyLine();
        System.out.printf(MESSAGE_FORMAT, message);
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}
