package subway.controller.functioncontroller;

import subway.controller.FunctionController;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.validator.StationValidation;
import subway.view.*;
import subway.view.stationoutput.StationInfoView;
import subway.view.stationoutput.StationOutputView;

import java.util.Scanner;

public class StationController extends FunctionController {
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
        if (userChoice.equals(REGISTER)) {
            return registerStation(scanner);
        }
        if (userChoice.equals(DELETE)) {
            return deleteStation(scanner);
        }
        if (userChoice.equals(PRINT)) {
            return printStation(scanner);
        }
        if (userChoice.equals(BACK)) {
            return true;
        }
        return false;
    }

    private static boolean registerStation(Scanner scanner) {
        String userInputStation = getRegisterStationUserInput(scanner);
        if (userInputStation.equals(INVALID_INPUT)) {
            return false;
        }
        registerStationToDataBase(userInputStation);
        return true;
    }

    private static String getRegisterStationUserInput(Scanner scanner) {
        StationOutputView.printRegisterStationInstruction();
        String userInputStation = InputView.getInput(scanner);
        if (!StationValidation.checkRegisterStationInput(userInputStation)) {
            return INVALID_INPUT;
        }
        return userInputStation;
    }

    private static void registerStationToDataBase(String userInputStation) {
        Station newStation = new Station(userInputStation);
        StationRepository.addStation(newStation);
        StationInfoView.printRegisterInfo();
    }

    private static boolean deleteStation(Scanner scanner) {
        String userInputStation = getDeleteStationUserInput(scanner);
        if (userInputStation.equals(INVALID_INPUT)) {
            return false;
        }
        deleteStationFromDataBase(userInputStation);
        return true;
    }

    private static String getDeleteStationUserInput(Scanner scanner) {
        StationOutputView.printDeleteStationInstruction();
        String userInputStation = InputView.getInput(scanner);
        if (!StationValidation.checkDeleteStationInput(userInputStation)) {
            return INVALID_INPUT;
        }
        return userInputStation;
    }

    private static void deleteStationFromDataBase(String userInputStation) {
        StationRepository.deleteStation(userInputStation);
        StationInfoView.printDeleteInfo();
    }

    private static boolean printStation(Scanner scanner) {
        StationOutputView.printStationList();
        StationInfoView.printStation();
        return true;
    }
}
