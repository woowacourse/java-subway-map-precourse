package subway.view;

import subway.menu.MainMenu;
import subway.menu.StationMenu;
import subway.utils.Validator;

import java.util.Scanner;

public class StationInputView {

    public static String menu(Scanner scanner) {
        System.out.println("## 원하는 기능을 선택하세요.");
        try {
            String selection = scanner.nextLine();
            Validator.menu(StationMenu.class, selection);
            return selection;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return menu(scanner);
        }
    }

    public static String register(Scanner scanner) {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        String name = scanner.nextLine();
        Validator.registerStation(name);
        return name;
    }

    public static String remove(Scanner scanner) {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        String name = scanner.nextLine();
        Validator.removeStation(name);
        return name;
    }

}
