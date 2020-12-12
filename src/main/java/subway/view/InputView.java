package subway.view;

import java.util.Scanner;

import subway.controller.exception.NameFormatException;
import subway.controller.exception.StationValidator;
import subway.view.exception.MenuSelectionException;
import subway.view.exception.MenuValidator;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in);

    public static String receiveMenu(String menuType) {
        System.out.println("## 원하는 기능을 선택하세요.");
        try {
            String menu = SCANNER.nextLine();
            MenuValidator.validateMenuSelection(menuType, menu);
            return menu;
        } catch (MenuSelectionException e) {
            System.out.println(e.getMessage());
            return receiveMenu(menuType);
        }
    }

    public static String receiveStationName(String message) {
        System.out.println(message);
        return SCANNER.nextLine();
    }
}
