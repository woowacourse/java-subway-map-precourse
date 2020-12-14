package subway.view;

import subway.menu.MainMenu;
import subway.feature.MenuFeature;

import java.util.Scanner;

public class MainInputView extends View {

    public static String mainMenu(Scanner scanner) {
        System.out.println(POUND_KEY + SELECT_FEATURE);
        try {
            String input = scanner.nextLine().trim();
            MenuFeature.mapInputToSelection(MainMenu.class, input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return mainMenu(scanner);
        }
    }

}
