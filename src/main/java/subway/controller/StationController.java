package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.validator.StationValidation;
import subway.view.*;
import subway.view.stationoutput.StationInfoView;
import subway.view.stationoutput.StationOutputView;

import java.util.Scanner;

public class StationController {
    private static final String STATION_REGISTER = "1";
    private static final String STATION_DELETE = "2";
    private static final String STATION_PRINT = "3";
    private static final String BACK = "B";

    public static void start(Scanner scanner) {
        runStationController(scanner);
    }

    private static void runStationController(Scanner scanner) {
        String userChoice = "";
        boolean stationControllerDone = false;
        while (!stationControllerDone) {
            StationOutputView.printOption();
            userChoice = getUserChoice(scanner);
            stationControllerDone = startChosenStationFunction(userChoice, scanner);
        }
    }

    private static String getUserChoice(Scanner scanner) {
        String userChoice = null;
        boolean validChoice = false;
        while (!validChoice) {
            StationOutputView.printOptionInstruction();
            userChoice = InputView.getInput(scanner);
            validChoice = StationValidation.checkControllerInput(userChoice);
        }
        return userChoice;
    }

    private static boolean startChosenStationFunction(String userChoice, Scanner scanner) {
        if (userChoice.equals(STATION_REGISTER)) {
            return registerStation(scanner);
        }
        if (userChoice.equals(STATION_DELETE)) {
            return deleteStation(scanner);
        }
        if (userChoice.equals(STATION_PRINT)) {
            return printStation(scanner);
        }
        if (userChoice.equals(BACK)) {
            return true;
        }
        return false;
    }

    private static boolean registerStation(Scanner scanner) {
        StationOutputView.printRegisterStationInstruction();
        String userInputStation = InputView.getInput(scanner);
        boolean validInput = StationValidation.checkRegisterStationInput(userInputStation);
        if (!validInput) {
            return false;
        }
        Station newStation = new Station(userInputStation);
        StationRepository.addStation(newStation);
        StationInfoView.printRegisterInfo();
        return true;
    }

    private static boolean deleteStation(Scanner scanner) {
        StationOutputView.printDeleteStationInstruction();
        String userInputStation = InputView.getInput(scanner);
        boolean validInput = StationValidation.checkDeleteStationInput(userInputStation);
        if (!validInput) {
            return false;
        }
        StationRepository.deleteStation(userInputStation);
        StationInfoView.printDeleteInfo();
        return true;
    }

    private static boolean printStation(Scanner scanner) {
        StationOutputView.printStationList();
        StationInfoView.printStation();
        return true;
    }

}
