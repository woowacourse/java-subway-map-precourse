package subway.view;

import subway.menu.SectionMenu;

import java.util.Scanner;

public class SectionInputView {

    public static String menu(Scanner scanner) {
        System.out.println("## 구간 관리 화면");
        System.out.println(SectionMenu.getMenu());
        System.out.println("## 원하는 기능을 선택하세요.");

        try {
            return SectionMenu.validateInput(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("\n[ERROR] 입력이 잘못되었습니다.\n");
            return menu(scanner);
        }
    }

    public static String register (Scanner scanner) {
        System.out.println("## 등록할 구간 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String remove (Scanner scanner) {
        System.out.println("## 삭제할 구간 이름을 입력하세요.");
        return scanner.nextLine();
    }

}
