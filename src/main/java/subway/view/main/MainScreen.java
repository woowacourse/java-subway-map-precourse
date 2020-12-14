package subway.view.main;

import subway.exception.SubwayException;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.TextCollection;

import java.util.Arrays;

public class MainScreen {

    public static MainMenu selectMenu() {
        String input = InputView.inputFunction();
        if (!MainMenu.isValidInput(input)) {
            throw new SubwayException(TextCollection.WRONG_MENU_INPUT_MESSAGE);
        }
        return MainMenu.findMenuByKey(input);
    }

    public static void showMenu() {
        OutputView.printQuestion(TextCollection.MAIN_SCREEN_MESSAGE);
        Arrays.stream(MainMenu.values()).forEach(menu -> {
            System.out.println(menu.getKey() + ". " + menu.getTitle());
        });
    }
}
