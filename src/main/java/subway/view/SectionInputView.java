package subway.view;

import subway.menu.SectionMenu;
import subway.menu.StationMenu;
import subway.utils.Validator;

import java.util.Scanner;

public class SectionInputView {

    public static String menu(Scanner scanner) {
        System.out.println("## 원하는 기능을 선택하세요.");
        try {
            String selection = scanner.nextLine();
            return selection;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return menu(scanner);
        }
    }

    public static String lineForRegister(Scanner scanner) {
        System.out.println("## 노선을 입력하세요.");
        return scanner.nextLine();
    }

    public static String stationForRegister(Scanner scanner) {
        System.out.println("## 역을 입력하세요.");
        return scanner.nextLine();
    }

    public static int sequenceForRegister(Scanner scanner) {
        System.out.println("## 순서를 입력하세요.");
        return Integer.parseInt(scanner.nextLine());
    }
}
