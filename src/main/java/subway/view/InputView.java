package subway.view;

import Utils.Validator;
import subway.Constant;
import subway.domain.menu.MainMenu;
import subway.domain.menu.ManagementMenu;

import java.util.List;
import java.util.Scanner;

public class InputView {

    public InputView() {
    }

    public static String inputMainMenu(Scanner scanner) {
        String inputData = scanner.nextLine();
        if (!MainMenu.isValidOrder(inputData)) {
            throw new IllegalArgumentException(Constant.ILLEGAL_ARGUMENT_EXCEPTION_INVALID_MENU_ORDER);
        }
        return inputData;
    }

    public static String inputManagementMenu(Scanner scanner, List<ManagementMenu> menuList) {
        String inputData = scanner.nextLine();
        for (ManagementMenu menu : menuList) {
            if (menu.getOrder().equals(inputData)) {
                return inputData;
            }
        }
        throw new IllegalArgumentException(Constant.ILLEGAL_ARGUMENT_EXCEPTION_INVALID_MENU_ORDER);
    }

    public static String inputData(Scanner scanner) {
        String inputData = scanner.nextLine();
        Validator.checkDataLength(inputData);
        return inputData;
    }
}
