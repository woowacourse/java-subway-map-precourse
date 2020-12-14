package subway.view;

import subway.menu.MenuFeature;
import subway.menu.SectionMenu;

import java.util.Scanner;

public class SectionInputView {

    public static String menu(Scanner scanner) {
        System.out.println("## 원하는 기능을 선택하세요.");
        try {
            String selection = scanner.nextLine();
            MenuFeature.validate(SectionMenu.class, selection);
            return selection;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return menu(scanner);
        }
    }

    public static String line(Scanner scanner) {
        System.out.println("## 노선을 입력하세요.");
        return scanner.nextLine();
    }

    public static String station(Scanner scanner) {
        System.out.println("## 역을 입력하세요.");
        return scanner.nextLine();
    }

    public static int sequence(Scanner scanner) {
        System.out.println("## 순서를 입력하세요.");
        return Integer.parseInt(scanner.nextLine());
    }
}
