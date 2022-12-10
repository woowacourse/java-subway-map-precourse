package subway.controllers;

import contants.MainMenu;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class MainController {
    private final Scanner scanner;

    public MainController(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void run() {
        OutputView.printMainMenu(MainMenu.getWholeMenu());
        selectMenu();
    }

    private static void selectMenu() {
        OutputView.printSelectFunction();
        String selection = InputView.selectFunction();
        if (MainMenu.FIRST.getUserInput().equals(selection)) {
            StationController.run();
        }
        if (MainMenu.SECOND.getUserInput().equals(selection)) {
            LineController.run();
        }
        if (MainMenu.THIRD.getUserInput().equals(selection)) {

        }
        if (MainMenu.FOURTH.getUserInput().equals(selection)) {

        }
        if (MainMenu.QUIT.getUserInput().equals(selection)) {

        }
    }
}
