package subway.controllers;

import constants.MainMenu;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class MainController {
    private final Scanner scanner;

    public MainController(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void run() {
        selectMenu();
    }

    private static void selectMenu() {
        boolean quit = false;
        while (!quit) {
            try {
                quit = runMenu(InputView.selectMainFunction());
            } catch (IllegalArgumentException exception) {
                OutputView.print(exception.getMessage());
                run();
            }
        }
    }

    private static boolean runMenu(String selection) {
        if (MainMenu.FIRST.getUserInput().equals(selection)) {
            StationController.run();
        }
        if (MainMenu.SECOND.getUserInput().equals(selection)) {
            LineController.run();
        }
        if (MainMenu.THIRD.getUserInput().equals(selection)) {
            SectionController.run();
        }
        if (MainMenu.FOURTH.getUserInput().equals(selection)) {
            SubwayPrintController.run();
        }
        if (MainMenu.QUIT.getUserInput().equals(selection)) {
            OutputView.printFinishSystem();
            return true;
        }
        return false;
    }
}
