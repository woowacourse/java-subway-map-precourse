package subway.views;

import subway.menus.LineMenu;
import subway.menus.MainMenu;
import subway.menus.StationMenu;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final String NOT_EXIST_MAIN_MENU_SELECTION = "[ERROR] 선택할 수 없는 기능입니다.";

    private InputView() {
    }

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
            .anyMatch(menu -> menu.getOption().equals(selection));
        return isExist;
    }

    public static String selectStationMenu(Scanner scanner) {
        String selection = userInput(scanner);
        checkExistStationMenu(selection);
        return selection;
    }

    private static void checkExistStationMenu(String selection) {
        if (!isExistStationMenu(selection)) {
            throw new IllegalArgumentException(NOT_EXIST_MAIN_MENU_SELECTION);
        }
    }

    private static boolean isExistStationMenu(String selection) {
        boolean isExist = Arrays.stream(StationMenu.values())
            .anyMatch(menu -> menu.getOption().equals(selection));
        return isExist;
    }

    public static String selectLineMenu(Scanner scanner) {
        String selection = userInput(scanner);
        checkExistLineMenu(selection);
        return selection;
    }

    private static void checkExistLineMenu(String selection) {
        if (!isExistLineMenu(selection)) {
            throw new IllegalArgumentException(NOT_EXIST_MAIN_MENU_SELECTION);
        }
    }

    private static boolean isExistLineMenu(String selection) {
        boolean isExist = Arrays.stream(LineMenu.values())
            .anyMatch(menu -> menu.getOption().equals(selection));
        return isExist;
    }
}
