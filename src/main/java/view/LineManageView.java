package view;

import java.util.Scanner;
import controller.LineManageController;

public class LineManageView {
    private static final String INPUT_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String INPUT_BACK = "B";
    private Scanner scanner;

    private static final String MENU =
            "## 노선 관리 화면\n" + "1. 노선 등록\n" + "2. 노선 삭제\n" + "3. 노선 조회\n" + "B. 돌아가기\n";

    private LineManageController controller;

    public LineManageView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setController(LineManageController controller) {
        this.controller = controller;
    }

    public void showMenu() {
        printMessage(MENU);
    }

    public void printMessage(String s) {
        System.out.println(s);
    }

    public void run() {
        while (true) {
            showMenu();
            String input = input();
            if (input.equals(INPUT_BACK)) {
                break;
            }
        }
    }

    public String input() {
        return scanner.nextLine();
    }
}
