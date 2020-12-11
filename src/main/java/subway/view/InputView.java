package subway.view;

import java.util.Scanner;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in);

    public static String receiveMenu(String menuType) {
        System.out.println("## 원하는 기능을 선택하세요.");
        String menu = SCANNER.nextLine();
        try {
            MenuValidator.validateMenuSelection(menuType, menu);
            return menu;
        } catch (MenuSelectionException e) {
            System.out.println(e.getMessage());
            return receiveMenu(menuType);
        }
    }
}
