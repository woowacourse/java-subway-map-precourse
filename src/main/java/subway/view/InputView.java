package subway.view;

import java.util.Scanner;

public class InputView {
    private static final String FUNCTION_MENU_LABEL = "## 메인 화면";
    private static final String FUNCTION_MENU_STATION_CARE = "1. 역 관리";
    private static final String FUNCTION_MENU_LINE_CARE = "2. 노선 관리";
    private static final String FUNCTION_MENU_AREA_CARE = "3. 구간 관리";
    private static final String FUNCTION_MENU_SHOW_MAP = "4. 지하철 노선도 출력";
    private static final String FUNCTION_MENU_QUIT = "Q. 종료";

    private static final String CHOOSE_FUNCTION = "## 원하는 기능을 선택하세요.";
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputFunction() {
        System.out.println();
        System.out.println(FUNCTION_MENU_LABEL);
        System.out.println(FUNCTION_MENU_STATION_CARE);
        System.out.println(FUNCTION_MENU_LINE_CARE);
        System.out.println(FUNCTION_MENU_AREA_CARE);
        System.out.println(FUNCTION_MENU_SHOW_MAP);
        System.out.println(FUNCTION_MENU_QUIT);
        return userStringInput(CHOOSE_FUNCTION);
    }

    private String userStringInput(String specificInfo) {
        System.out.println();
        System.out.println(specificInfo);
        return scanner.nextLine();
    }
}
