package subway.views.stationviews;

import java.util.Arrays;
import java.util.Scanner;

public class StationInputView {
    private static final String NOT_EXIST_MAIN_MENU_SELECTION = "[ERROR] 선택할 수 없는 기능입니다.";

    public static String selectStationMenu(Scanner scanner) {
        String selection = userInput(scanner);
        checkExistStationMenu(selection);
        return selection;
    }

    private static String userInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void checkExistStationMenu(String selection) {
        if (!isExistStationMenu(selection)) {
            throw new IllegalArgumentException(NOT_EXIST_MAIN_MENU_SELECTION);
        }
    }

    private static boolean isExistStationMenu(String selection) {
        boolean isExist = Arrays.stream(StationMenu.values())
            .anyMatch(menu -> menu.getOptionalItem().equals(selection));
        return isExist;
    }
}
