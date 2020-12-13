package subway.view;

import subway.menu.LineMenu;

import java.util.Scanner;

public class LineInputView {

    public static String menu(Scanner scanner) {
        System.out.println("## 노선 관리 화면");
        System.out.println(LineMenu.getMenu());
        System.out.println("## 원하는 기능을 선택하세요.");

        return scanner.nextLine();
    }

    public static String register (Scanner scanner) {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String remove (Scanner scanner) {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String upBoundTerminus (Scanner scanner) {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String downBoundTerminus (Scanner scanner) {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        return scanner.nextLine();
    }

}
