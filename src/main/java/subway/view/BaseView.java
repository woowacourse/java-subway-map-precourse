package subway.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import utils.Category;
import utils.ScriptUtils;

public class BaseView {
    public static final int EXIT = 0;
    public static final int ERROR = -1;
    public static final int START = 1;
    public static final int[] LENGTH_OF_MENU = {4, 3, 3, 2};
    List<String> gameExitValue = Arrays.asList("Q", "q");

    public BaseView() {
    }

    public void printMenu(String script) {
        System.out.println(script);
    }

    public int selectMenu(Scanner scanner) {
        System.out.println(ScriptUtils.ASK_SELECTION);
        String input = scanner.nextLine();

        if (gameExitValue.contains(input)) {
            return EXIT;
        }

        return validateSelection(input);
    }

    public int validateSelection(String input) {
        int number;

        try {
            number = Integer.parseInt(input);
            if (number < START || number > LENGTH_OF_MENU[Category.MAIN.ordinal()]) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ScriptUtils.ERROR_OUT_OF_VALUE);
            return ERROR;
        }
        return number;
    }
}
