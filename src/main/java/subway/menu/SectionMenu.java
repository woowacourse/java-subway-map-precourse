package subway.menu;

import java.util.Scanner;

public class SectionMenu {
    private static final String MENU_TITLE = "## 노선 관리 화면";
    private static final String MENU1 = "1. 구간 등록";
    private static final String MENU2 = "2. 구간 삭제";
    private static final String BACK = "B. 돌아가기";
    private static final String CHOICE_MESSAGE = "## 원하는 기능을 선택하세요.";

    private Scanner scanner;

    public SectionMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startSectionMenu() {

    }

    private void printMainMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(MENU_TITLE).append("\n")
                .append(MENU1).append("\n")
                .append(MENU2).append("\n")
                .append(BACK).append("\n\n")
                .append(CHOICE_MESSAGE);
        System.out.println(sb);
    }
}
