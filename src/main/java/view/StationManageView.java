package view;

import java.util.Scanner;
import controller.StationManageController;

public class StationManageView {
    private static final String INPUT_MESSAGE = "## 원하는 기능을 선택하세요.";
    private Scanner scanner;

    private static final String MENU =
            "## 역 관리 화면\n" + "1. 역 등록\n" + "2. 역 삭제\n" + "3. 역 조회\n" + "B. 돌아가기\n";

    private static final String INPUT_FOR_BACK = "B";
    private static final String ERROR_INVALID_INPUT = "\n[ERROR] 유효하지 않은 입력입니다.\n";

    private StationManageController controller;

    public StationManageView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setController(StationManageController controller) {
        this.controller = controller;
    }

    public void showMenu() {
        printMessage(MENU);
    }

    public void run() {
        showMenu();
        printInputMessage();
        String input = input();
        while (!controller.validateInput(input)) {
            printInvalidInputMessage();
            printInputMessage();
            input = input();
        }
        if (input.equals(INPUT_FOR_BACK)) {
            return;
        }
        controller.processInput(input);
    }


    public void printMessage(String s) {
        System.out.println(s);
    }

    public void printInvalidInputMessage() {
        printMessage(ERROR_INVALID_INPUT);
    }

    public void printInputMessage() {
        printMessage(INPUT_MESSAGE);
    }

    public String input() {
        return scanner.nextLine();
    }
}
