package subway.menu;

import java.util.Scanner;

public class StationMenu {
    private static final String MENU_TITLE = "## 역 관리 화면";
    private static final String MENU1 = "1. 역 등록";
    private static final String MENU2 = "2. 역 삭제";
    private static final String MENU3 = "3. 역 조회";
    private static final String BACK = "B. 돌아가기";
    private static final String CHOICE_MESSAGE = "## 원하는 기능을 선택하세요.";

    private Scanner scanner;

    public StationMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startStationMenu() {
        this.scanner = scanner;
        String input = "";
        while (!input.equals("B")) {
            printStationMenu();
            input = this.scanner.nextLine();
        }
    }

    public void printStationMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(MENU_TITLE).append("\n")
                .append(MENU1).append("\n")
                .append(MENU2).append("\n")
                .append(MENU3).append("\n")
                .append(BACK).append("\n")
                .append(CHOICE_MESSAGE);
        System.out.println(sb);
    }
}
