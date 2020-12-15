package view;

import java.util.Scanner;
import controller.SectionManageController;

public class SectionManageView {
    private static final String MENU = "## 구간 관리 화면\n" + "1. 구간 등록\n" + "2. 구간 삭제\n" + "B. 돌아가기";
    private static final String INPUT_MESSAGE = "## 원하는 기능을 선택하세요.";

    private Scanner scanner;
    private SectionManageController controller;

    public SectionManageView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setController(SectionManageController controller) {
        this.controller = controller;
    }

    public void run() {
        showMenu();
        printMessage(INPUT_MESSAGE);
        String input = input();
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
