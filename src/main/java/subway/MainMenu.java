package subway;

import java.util.Scanner;

public class MainMenu {
    private final Scanner scanner;
    private boolean doNext = true;


    public MainMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public String run() {
        String parsedInput = input();
        if (parsedInput.matches("[Qq]")) {
            doNext = false;
        }
        return parsedInput;
    }

    public String input() {
        printMenuScreen();
        return parseMenuNumber();
    }

    public void printMenuScreen() {
        System.out.println("## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
    }

    public String parseMenuNumber() {
        String userInput = scanner.nextLine();
        try {
            return Validate.mainMenuInt(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return input();
        }
    }

    public boolean doNext() {
        return doNext;
    }
}
