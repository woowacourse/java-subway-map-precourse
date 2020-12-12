package subway.view;

import java.util.Scanner;

import subway.view.validator.MenuSelectionException;
import subway.view.validator.MenuValidator;
import subway.view.validator.NameFormatException;
import subway.view.validator.StationNameValidator;

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

    public static String receiveStationName() {
        try {
            String stationName = SCANNER.nextLine();
            StationNameValidator.validateStationName(stationName);
            return stationName;
        } catch (NameFormatException e) {
            System.out.println(e.getMessage());
            return receiveStationName();
        }
    }
}
