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
        chooseController(scanner);
    }

    private void chooseController(Scanner scanner) {
        String userChoice = "";
        while (!userChoice.equals(QUIT)) {
            MainOptionView.printMainControllerOption();
            userChoice = getUserMainControllerChoice(scanner);
            if (userChoice.equals(STATION_CONTROL)) {
                StationController.start(scanner);
            } else if (userChoice.equals(LINE_CONTROL)) {
                LineController.start(scanner);
            } else if (userChoice.equals(LINE_SECTION_CONTROL)) {
                LineSectionController.start(scanner);
            } else if (userChoice.equals(MAP_PRINT_CONTROL)) {
                MapPrintController.start(scanner);
            }
        }
    }

    private String getUserMainControllerChoice(Scanner scanner) {
        String userChoice = null;
        boolean validChoice = false;
        while (!validChoice) {
            MainOptionView.printOptionInstruction();
            userChoice = InputView.getInput(scanner);
            validChoice = Validation.checkMainControllerInput(userChoice);
        }
        return userChoice;
    }
}
