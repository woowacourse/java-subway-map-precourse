package Controller;

import java.util.Scanner;

public class SectionController {
    public static void runSectionController(Scanner scanner) {
        System.out.println("## 구간 관리 화면\n" +
                "1. 구간 등록\n" +
                "2. 구간 삭제\n" +
                "B. 돌아가기\n" +
                "\n" +
                "## 원하는 기능을 선택하세요.");

        String userInput = scanner.nextLine();

        boolean inputCheck = false;
        if (userInput.equals("1")) {
            inputCheck = true;
        }
        if (userInput.equals("2")) {
            inputCheck = true;
        }
        if (userInput.equals("B")) {
            inputCheck = true;
            SubwayController.run(scanner);
        }
        if (inputCheck == false) {
            System.out.println("[ERROR] 올바른 번호를 입력해주세요");
            SectionController.runSectionController(scanner);
        }
    }
}
