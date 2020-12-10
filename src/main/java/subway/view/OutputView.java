package subway.view;

import subway.view.menu.MainMenu;

import java.util.Iterator;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String MENU_FORMAT = "%s. %s";

    public static void showErrorMessage(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }

    public static void showMainMenu() {
        Iterator<String> menuIterator = MainMenu.getMenu().iterator();
        Iterator<String> menuSelectionsIterator = MainMenu.getMenuSelections().iterator();

        while (menuIterator.hasNext() && menuSelectionsIterator.hasNext()) {
            System.out.println(String.format(MENU_FORMAT, menuSelectionsIterator.next(), menuIterator.next()));
        }
    }
}
