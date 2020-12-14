package subway.view;

import subway.domain.menu.Menu;
import subway.domain.menu.MenuItem;

public class MenuOutputView extends OutputView {
    private static final String MENU_ITEM_FORMAT = "%s. %s%n";
    private static final String REQUEST_SELECT_FUNCTION = "원하는 기능을 선택하세요.";

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
}
