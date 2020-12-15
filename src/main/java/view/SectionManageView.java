package view;

import java.util.Scanner;
import controller.SectionManageController;

public class SectionManageView {
    private static final String MENU = "## 구간 관리 화면\n" + "1. 구간 등록\n" + "2. 구간 삭제\n" + "B. 돌아가기";
    private static final String INPUT_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String INVALID_INPUT = "\n[ERROR] 유효하지 않은 입력입니다.\n";
    private static final String INPUT_BACK = "B";
    private Scanner scanner;
    private SectionManageController controller;

    public SectionManageView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setController(SectionManageController controller) {
        this.controller = controller;
    }

    public void run() {
        while (true) {
            showMenu();
            printMessage(INPUT_MESSAGE);
            String input = input();
            if (input.equals(INPUT_BACK)) {
                break;
            }
            while (!controller.validateInput(input)) {
                printMessage(INVALID_INPUT);
                printMessage(INPUT_MESSAGE);
                input = input();
            }
            controller.processInput(input);
        }
    }

    private void showMenu() {
        printMessage(MENU);
    }

    public void printMessage(String s) {
        System.out.println(s);
    }

    public String input() {
        return scanner.nextLine();
    }
}
