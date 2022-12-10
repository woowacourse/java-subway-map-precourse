package subway.controllers;

import contants.MainMenu;
import contants.SectionController;
import subway.domain.Initializer;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class MainController {
    private final Scanner scanner;

    public MainController(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void run() {
        Initializer.init();
        selectMenu();
    }

    private static void selectMenu() {
        String selection = "";
        while (!MainMenu.isQuit(selection)) {
            OutputView.printMainMenu(MainMenu.getWholeMenu());
            OutputView.printSelectFunction();
            selection = InputView.selectFunction();
            if (MainMenu.FIRST.getUserInput().equals(selection)) {
                try {
                    StationController.run();
                } catch (IllegalArgumentException exception) {
                    OutputView.print(exception.getMessage());
                    StationController.run();
                }
            }
            if (MainMenu.SECOND.getUserInput().equals(selection)) {
                try {
                    LineController.run();
                } catch (IllegalArgumentException exception) {
                    OutputView.print(exception.getMessage());
                    LineController.run();
                }
            }
            if (MainMenu.THIRD.getUserInput().equals(selection)) {
                try {
                    SectionController.run();
                } catch (IllegalArgumentException exception) {
                    OutputView.print(exception.getMessage());
                    SectionController.run();
                }
            }
            if (MainMenu.FOURTH.getUserInput().equals(selection)) {
                try {
                    SubwayPrintController.run();
                } catch (IllegalArgumentException exception) {
                    OutputView.print(exception.getMessage());
                    SubwayPrintController.run();
                }
            }
            if (MainMenu.QUIT.getUserInput().equals(selection)) {
                OutputView.printFinishSystem();
            }
        }
    }
}
