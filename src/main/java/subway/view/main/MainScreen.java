package subway.view.main;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.TextCollection;

import java.util.Arrays;

public class MainScreen {

    public static MainMenu selectMenu() {
        while (true) {
            showMenu();
            String input = InputView.inputFunction();
            if (!MainMenu.isValidInput(input)) {
                OutputView.printError(TextCollection.ERROR);
                continue;
            }
            return MainMenu.findMenuByKey(input);
        }
    }

    private static void showMenu() {
        InputView.printQuestion(TextCollection.MAIN_SCREEN_MESSAGE);
        Arrays.stream(MainMenu.values()).forEach(menu -> {
            System.out.println(menu.getKey() + ". " + menu.getTitle());
        });
        System.out.println();
    }
}
