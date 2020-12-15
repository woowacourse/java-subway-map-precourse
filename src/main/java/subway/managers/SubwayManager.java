package subway.managers;

import subway.exceptions.SubwayException;
import subway.exceptions.Validation;
import subway.managers.StationManager;
import subway.views.SystemOutput;
import subway.views.UserInput;

import java.util.Scanner;

public class SubwayManager {
    private static UserInput userInput;

    public SubwayManager(Scanner scanner) {
        this.runManager(scanner);
    }

    public static void runManager(Scanner scanner) {
        userInput = new UserInput(scanner);
        SystemOutput.printMainMessage();
        String input = userInput.getMainInput();
        mainOption(scanner, userInput, input);
    }

    private static void mainOption(Scanner scanner, UserInput userInput, String input) {
        try {
            new Validation().mainOptionValidation(input);
        } catch (SubwayException e) {
            runManager(scanner);
        };
        if (input.equals("1")) {
            StationManager.runStationManager(scanner, userInput);
            runManager(scanner);
        }
        if (input.equals("2")) {
            LineManager.runLineManager(scanner, userInput);
            runManager(scanner);
        }
        if (input.equals("3")) {
            SectionManager.runSectionManager(scanner, userInput);
            runManager(scanner);
        }
        if (input.equals("4")) {
            subwayMapManager();
        }
        if (input.equals("Q")) {
            return;
        }
    }

    private static void stationManager(UserInput userInput) {

    }

    private static void lineManager() {
        // SystemOutput.printLineMessage();
    }

    private static void sectionManager() {
//        SystemOutput.printSectionMessage();
    }

    private static void subwayMapManager() {

    }
}
