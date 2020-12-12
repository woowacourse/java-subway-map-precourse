package subway.views.mainviews;

import java.util.Arrays;
import java.util.Scanner;

public class MainInputView {
    private static final String NOT_EXIST_MAIN_MENU_SELECTION = "[ERROR] 선택할 수 없는 기능입니다.";

    public static String selectMainMenu(Scanner scanner) {
        String selection = userInput(scanner);
        checkExistMainMenu(selection);
        return selection;
    }

    private static String userInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void checkExistMainMenu(String selection) {
        if (!isExistMainMenu(selection)) {
            throw new IllegalArgumentException(NOT_EXIST_MAIN_MENU_SELECTION);
        }
    }

    private static boolean isExistMainMenu(String selection) {
        boolean isExist = Arrays.stream(MainMenu.values())
                            .anyMatch(menu -> menu.getOptionalItem().equals(selection));
        return isExist;
    }
}
