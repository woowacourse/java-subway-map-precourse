package subway.view;

import subway.menu.LineMenu;

import java.util.Scanner;

public class LineInputView {

    public static String menu(Scanner scanner) {
        System.out.println("## 노선 관리 화면");
        System.out.println(LineMenu.getMenu());
        System.out.println("## 원하는 기능을 선택하세요.");

        try {
            return LineMenu.validateInput(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("\n[ERROR] 입력이 잘못되었습니다.\n");
            return menu(scanner);
        }
    }

    public static String register (Scanner scanner) {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String remove (Scanner scanner) {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        return scanner.nextLine();
    }

}
