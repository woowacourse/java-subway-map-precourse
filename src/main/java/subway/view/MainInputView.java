package subway.view;

import subway.menu.LineMenu;
import subway.menu.MainMenu;

import java.util.Scanner;

public class MainInputView {

    private static final String newLine = "\n";

    public static String mainMenu(Scanner scanner) {
        System.out.println("## 메인 화면");
        System.out.println(MainMenu.getMenu());
        System.out.println(newLine + "## 원하는 기능을 선택하세요.");

        try {
            return scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println(newLine + "[ERROR] 입력이 잘못되었습니다." + newLine);
            return mainMenu(scanner);
        }
    }
}
