package subway.view;

import subway.view.menu.MainMenu;
import subway.view.menu.Menu;

import java.util.Iterator;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String MENU_FORMAT = "%s. %s";

    private static MainMenu mainMenu = MainMenu.getInstance();

    public static void showErrorMessage(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }

    public static void showMainMenu() {
        showMenu(mainMenu);
    }

    public static void showMenu(Menu menu) {
        Iterator<String> menuIterator = menu.getMenu().iterator();
        Iterator<String> menuSelectionsIterator = menu.getMenuSelections().iterator();

        while (menuIterator.hasNext() && menuSelectionsIterator.hasNext()) {
            System.out.println(String.format(MENU_FORMAT, menuSelectionsIterator.next(), menuIterator.next()));
        }
    }
}
