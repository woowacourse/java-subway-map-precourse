package subway.view;

import subway.menu.LineMenu;
import subway.menu.MainMenu;
import subway.utils.Validator;

import java.util.Scanner;

public class MainInputView {

    private static final String newLine = "\n";

    public static String mainMenu(Scanner scanner) {
        System.out.println("## 메인 화면");
        System.out.println(MainMenu.getMenu());
        System.out.println(newLine + "## 원하는 기능을 선택하세요.");

        try {
            String input = scanner.nextLine();
            Validator.menu(MainMenu.class, input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return mainMenu(scanner);
        }
    }
}
