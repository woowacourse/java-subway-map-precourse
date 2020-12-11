package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MenuController {
    private static final List<String> MAIN_MENU_SIGN = Arrays.asList(new String[] {"1","2","3","4","Q"});

    public static String selectMainMenu(Scanner scanner) {
        OutputView.printMainScreen();
        return selectMenu(scanner);

    }

    private static String selectMenu(Scanner scanner) {
        OutputView.printMenuSelectScreen();
        return InputView.getInput(scanner);
    }

    public static boolean isValidMenu(String menu) {
        return MAIN_MENU_SIGN.contains(menu);
    }
}
