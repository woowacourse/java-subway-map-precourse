package subway.view.main;

import subway.exception.SubwayException;
import subway.view.InputView;
import subway.view.TextCollection;

import java.util.Arrays;

public class MainScreen {

    public static MainMenu selectMenu() {
        showMenu();
        String input = InputView.inputFunction();
        if (!MainMenu.isValidInput(input)) {
            throw new SubwayException(TextCollection.WRONG_MENU_INPUT_MESSAGE);
        }
        return MainMenu.findMenuByKey(input);
    }

    private static void showMenu() {
        InputView.printQuestion(TextCollection.MAIN_SCREEN_MESSAGE);
        Arrays.stream(MainMenu.values()).forEach(menu -> {
            System.out.println(menu.getKey() + ". " + menu.getTitle());
        });
    }
}
