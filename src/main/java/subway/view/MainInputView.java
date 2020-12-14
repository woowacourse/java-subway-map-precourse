package subway.view;

import subway.menu.MainMenu;
import subway.menu.MenuFeature;

import java.util.Scanner;

public class MainInputView extends View {

    public static String mainMenu(Scanner scanner) {
        System.out.println(POUND_KEY + SELECT_FEATURE);
        try {
            String input = scanner.nextLine();
            MenuFeature.findOne(MainMenu.class, input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return mainMenu(scanner);
        }
    }
}
