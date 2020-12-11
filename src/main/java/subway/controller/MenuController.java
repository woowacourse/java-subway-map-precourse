package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class MenuController {

    public static String selectMainMenu(Scanner scanner) {
        OutputView.printMainScreen();
        return selectMenu(scanner);

    }

    private static String selectMenu(Scanner scanner) {
        OutputView.printMenuSelectScreen();
        return InputView.getInput(scanner);
    }
}
