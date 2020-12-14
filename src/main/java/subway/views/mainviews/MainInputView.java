package subway.views.mainviews;

import subway.menus.MainMenu;
import subway.views.InputView;
import subway.views.OutputView;

import java.util.Scanner;

public class MainInputView implements InputView {
    private MainInputView() {
    }

    public static MainMenu selectMainMenu(Scanner scanner) {
        try {
            OutputView.printFeatureSelectMessage();
            return MainMenu.getMenu(InputView.userInput(scanner));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectMainMenu(scanner);
        }
    }
}
