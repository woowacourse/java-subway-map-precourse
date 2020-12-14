package subway.views.mainviews;

import subway.menus.MainMenu;
import subway.views.OutputView;

import java.util.Scanner;

public class MainInputView {
    private MainInputView() {
    }

    private static String userInput(Scanner scanner) {
        return scanner.nextLine();
    }

    public static MainMenu selectMainMenu(Scanner scanner) {
        try {
            OutputView.printFeatureSelectMessage();
            return MainMenu.getMenu(userInput(scanner));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectMainMenu(scanner);
        }
    }
}
