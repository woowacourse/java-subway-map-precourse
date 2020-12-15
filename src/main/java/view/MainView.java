package view;

import java.util.Scanner;
import controller.MainController;

public class MainView {
    private static final String INPUT_MESSAGE = "## 원하는 기능을 선택하세요.";
    private Scanner scanner;

    private String GUIDE_MESSAGE;
    private MainController controller;

    public MainView(Scanner scanner) {
        this.scanner = scanner;
        this.GUIDE_MESSAGE = "## 메인 화면\n1. 역관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료\n";
    }

    public void setController(MainController controller) {
        this.controller = controller;
    }

    public void printMessage(String s) {
        System.out.println(s);
    }

    public void printGuideMessage() {
        printMessage(GUIDE_MESSAGE);
    }

    public void printInputMessage() {
        printMessage(INPUT_MESSAGE);
    }

    public String input() {
        return scanner.nextLine();
    }

    public void run() {
        printGuideMessage();
        printInputMessage();
    }

    public void showLines() {
        printMessage(controller.getAllLinesInfo());
    }
}
