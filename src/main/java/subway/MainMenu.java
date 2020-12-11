package subway;

import java.util.Scanner;

public class MainMenu {
    private final Scanner scanner;
    private boolean doNext = true;


    public MainMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public int run() {
        int parsedInput = input();
        if (parsedInput == 0) {
            doNext = false;
        }
        return parsedInput;
    }

    public int input() {
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

    public int parseMenuNumber() {
        String userInput = scanner.nextLine();
        try {
            return Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            if (userInput.equals("Q")) {
                return 0;
            }
            System.out.println("[ERROR] 잘못된 입력입니다.");
            return run();
        }
    }

    public boolean doNext() {
        return doNext;
    }

}
