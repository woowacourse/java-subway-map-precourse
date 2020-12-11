package subway.view;

import subway.view.selection.Selection;
import subway.view.selection.Selections;

public class OutputView {
    private static final String SHARP_PREFIX = "## ";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String INFO_PREFIX = "[INFO] ";
    private static final String MENU_FORMAT = "%s. %s";

    public static void showErrorMessage(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
        newLine();
    }

    public static void showMenu(Selections selections, String viewName) {
        System.out.println(SHARP_PREFIX + viewName);
        for (Selection selection : selections.toList()) {
            System.out.println(String.format(MENU_FORMAT, selection.getValue(), selection.getDescription()));
        }
        newLine();
    }

    public static void printWithInfoPrefix(String string) {
        System.out.println(INFO_PREFIX + string);
    }

    private static void newLine() {
        System.out.println();
    }
}
