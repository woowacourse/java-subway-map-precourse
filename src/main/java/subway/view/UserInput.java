package subway.view;

import java.util.Scanner;

public class UserInput {

    private static final String REQUEST_SELECT_MENU_MESSAGE = "## 원하는 기능을 선택하세요.";

    public static String getMenu(Scanner scanner) {
        System.out.println();
        System.out.println(REQUEST_SELECT_MENU_MESSAGE);
        String menu = scanner.nextLine().toUpperCase();     // 소문자 입력 예외처리
        System.out.println();
        return menu;
    }
}
