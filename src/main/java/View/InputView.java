package View;

import java.util.Scanner;

public class InputView {

    private static final String CHOOSE_FEATURE = "## 원하는 기능을 선택하세요.";
    private static final int START = 0;
    private static Scanner scanner = null;
    private static String NEW_LINE_NAME = "## 등록할 노선 이름을 입력하세요.";
    private static String DELETE_LINE_NAME = "## 삭제할 노선 이름을 입력하세요";

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static char inputChoice() {
        System.out.println(CHOOSE_FEATURE);
        char choice = scanner.next().charAt(START);
        return choice;
    }

    public static String inputNewLineName() {
        System.out.println(NEW_LINE_NAME);
        String lineName = scanner.nextLine();
        return lineName;
    }

    public static String inputDeleteName() {
        System.out.println(DELETE_LINE_NAME);
        String lineName = scanner.nextLine();
        return lineName;
    }
}
