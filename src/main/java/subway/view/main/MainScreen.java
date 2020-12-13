package subway.view.main;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.main.MainMenu;

import java.util.Arrays;

public class MainScreen {
    private static final String MAIN_SCREEN_MESSAGE = "메인 화면";
    private static final String ERROR = "잘못된 입력입니다.";

    public static MainMenu selectMenu() {
        while (true) {
            showMenu();
            String input = InputView.inputFunction();
            if (!MainMenu.isValidInput(input)) {
                OutputView.printError(ERROR);
                continue;
            }
            return MainMenu.findMenuByKey(input);
        }
    }

    private static void showMenu() {
        InputView.printQuestion(MAIN_SCREEN_MESSAGE);
        Arrays.stream(MainMenu.values()).forEach(menu -> {
            System.out.println(menu.getKey() + ". " + menu.getTitle());
        });
        System.out.println();
    }
}
