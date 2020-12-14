package subway.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String receiveMenu(String menuType) {
        System.out.println("## 원하는 기능을 선택하세요.");
        try {
            String menu = SCANNER.nextLine();
            MenuInputValidator.validateMenuSelection(menuType, menu);
            return menu;
        } catch (MenuInputException e) {
            System.out.println(e.getMessage());
            return receiveMenu(menuType);
        }
    }

    public static String receiveName(String message) {
        System.out.println(message);
        return SCANNER.nextLine();
    }
}
