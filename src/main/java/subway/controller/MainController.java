package subway.controller;

import subway.view.InputView;
import subway.view.mainoutput.MainOptionView;
import subway.validator.Validation;

import java.util.Scanner;

public class MainController {
    private static final String STATION_CONTROL = "1";
    private static final String LINE_CONTROL = "2";
    private static final String LINE_SECTION_CONTROL = "3";
    private static final String MAP_PRINT_CONTROL = "4";
    private static final String QUIT = "Q";

    public void start(Scanner scanner) {
        InitialSetupController.initialSetup();
        runMainController(scanner);
    }

    private void runMainController(Scanner scanner) {
        String userChoice = "";
        while (!userChoice.equals(QUIT)) {
            MainOptionView.printOption();
            userChoice = getUserChoice(scanner);
            startChosenController(userChoice, scanner);
        }
    }

    private String getUserChoice(Scanner scanner) {
        String userChoice = null;
        boolean validChoice = false;
        while (!validChoice) {
            MainOptionView.printOptionInstruction();
            userChoice = InputView.getInput(scanner);
            validChoice = Validation.checkMainControllerInput(userChoice);
        }
        return userChoice;
    }

    private void startChosenController(String userChoice, Scanner scanner) {
        if (userChoice.equals(STATION_CONTROL)) {
            StationController.start(scanner);
        }
        if (userChoice.equals(LINE_CONTROL)) {
            LineController.start(scanner);
        }
        if (userChoice.equals(LINE_SECTION_CONTROL)) {
            LineSectionController.start(scanner);
        }
        if (userChoice.equals(MAP_PRINT_CONTROL)) {
            MapPrintController.start(scanner);
        }
    }
}
