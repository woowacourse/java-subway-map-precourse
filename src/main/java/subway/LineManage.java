package subway;

import java.util.Scanner;

public class LineManage {

    static final String ADD_LINE = "1";
    static final String DELETE_LINE = "2";
    static final String ALL_LINES = "3";
    static final String BACK_SCREEN = "B";
    static final int MIN_LINE_NAME_LENGTH = 2;

    static public void lineManage(Scanner scanner) {
        lineManagePrint();
        String lineManageInput = scanner.next();
        inputValidate(scanner, lineManageInput);
    }

    private static boolean inputValidate(Scanner scanner, String mainInput) {
        if (mainInput.equalsIgnoreCase(ADD_LINE)) {
            //addLinePrint(scanner);
            return true;
        }
        if (mainInput.equalsIgnoreCase(DELETE_LINE)) {
            //deleteLinePrint(scanner);
            return true;
        }
        if (mainInput.equalsIgnoreCase(ALL_LINES)) {
            //allLinesPrint();
            return true;
        }
        if (mainInput.equalsIgnoreCase(BACK_SCREEN)) {
            return true;
        }
        System.out.println("\n[ERROR] 선택할 수 없는 기능입니다.");
        throw new IllegalArgumentException();
    }

    private static void lineManagePrint() {
        System.out.println("\n## 노선 관리 화면\n"
            + "1. 노선 등록\n"
            + "2. 노선 삭제\n"
            + "3. 노선 조회\n"
            + "B. 돌아가기\n"
            + "\n"
            + "## 원하는 기능을 선택하세요.");
    }
}
