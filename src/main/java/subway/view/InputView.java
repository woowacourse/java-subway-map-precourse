package subway.view;

import subway.domain.MainMenuType;

import java.util.Scanner;

public class InputView {

    private static final String MAIN_MENU_MESSAGE = "## 메인 화면\n1. 역 관리\n2. 노선 관리\n" +
            "3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료";


    private InputView() {

    }

    public static MainMenuType inputMainMenu(Scanner scanner) {
        try {
            System.out.println(MAIN_MENU_MESSAGE);
            return MainMenuType.validateMainMenu(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMainMenu(scanner);
        }
    }


}
