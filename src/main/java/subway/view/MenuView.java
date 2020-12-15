package subway.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import utils.Category;
import utils.ScriptUtils;

public class MenuView {
    public static final int EXIT = 0;
    public static final int RETRY = -1;
    public static final int START = 1;
    public static final int[] LENGTH_OF_MENU = {4, 3, 3, 2};

    private Category category;
    List<String> exitValue;

    public MenuView() {
        this.category = Category.MAIN;
        this.exitValue = Arrays.asList("Q", "q");
    }

    public MenuView(Category category) {
        this.category = category;
        this.exitValue = Arrays.asList("B", "b");
    }

    public void printMenu() {
        System.out.println(ScriptUtils.MENUS[category.ordinal()]);
    }

    public int selectMenu(Scanner scanner) {
        System.out.println(ScriptUtils.ASK_SELECTION);
        String input = scanner.nextLine();

        if (exitValue.contains(input)) {
            return EXIT;
        }
        return validateSelection(input);
    }

    public int validateSelection(String input) {
        int number;

        try {
            number = Integer.parseInt(input);
            if (number < START || number > LENGTH_OF_MENU[category.ordinal()]) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ScriptUtils.ERROR_OUT_OF_VALUE);
            return RETRY;
        }
        return number;
    }
}
