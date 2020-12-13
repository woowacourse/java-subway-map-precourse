package subway.views;

import subway.menus.MainMenu;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final String NOT_EXIST_MAIN_MENU_SELECTION = "[ERROR] 선택할 수 없는 기능입니다.";

    private static String userInput(Scanner scanner) {
        return scanner.nextLine();
    }

    public static String selectMainMenu(Scanner scanner) {
        String selection = userInput(scanner);
        checkExistMainMenu(selection);
        return selection;
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
