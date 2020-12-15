package Controller;

import java.util.Scanner;

public class SubwayController {
    private static String userInput;

    public SubwayController(Scanner scanner) {
        run(scanner);
    }

    public static void run(Scanner scanner) {
        System.out.println("## 메인 화면\n" +
                "1. 역 관리\n" +
                "2. 노선 관리\n" +
                "3. 구간 관리\n" +
                "4. 지하철 노선도 출력\n" +
                "Q. 종료\n" +
                "\n" +
                "## 원하는 기능을 선택하세요.");
        userInput = scanner.nextLine();
        mainSelect(scanner);
    }

    private static void mainSelect(Scanner scanner) {
        boolean inputCheck = false;
        if (userInput.equals("1")) {
            inputCheck = true;
        }
        if (userInput.equals("2")) {
            inputCheck = true;
        }
        if (userInput.equals("3")) {
            inputCheck = true;
        }
        if (userInput.equals("4")) {
            inputCheck = true;
        }
        if (userInput.equals("Q")) {
            inputCheck = true;
        }
        if (inputCheck == false) {
            System.out.println("[ERROR] 올바른 번호를 입력해주세요");
        }
    }
}
