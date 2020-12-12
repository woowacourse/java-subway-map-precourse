package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import util.validator.Validation;

import java.util.Scanner;

public class StationController {
    private static final String STATION_REGISTER = "1";
    private static final String STATION_DELETE = "2";
    private static final String STATION_PRINT = "3";
    private static final String BACK = "B";

    public static void start(Scanner scanner) {
        chooseStationFunction(scanner);
    }

    private static void chooseStationFunction(Scanner scanner) {
        String userChoice = "";
        boolean stationControllerDone = false;
        while (!stationControllerDone) {
            OutputView.printStationControllerOption();
            userChoice = getUserStationControllerChoice(scanner);
            if (userChoice.equals(STATION_REGISTER)) {
                stationControllerDone = registerStation(scanner);
            } else if (userChoice.equals(STATION_DELETE)) {
                stationControllerDone = deleteStation(scanner);
            } else if (userChoice.equals(STATION_PRINT)) {
                stationControllerDone = printStation(scanner);
            } else if (userChoice.equals(BACK)) {
                stationControllerDone = true;
            }
        }
    }

    private static String getUserStationControllerChoice(Scanner scanner) {
        String userChoice = null;
        boolean validChoice = false;
        while (!validChoice) {
            OutputView.printOptionInstruction();
            userChoice = InputView.getInput(scanner);
            validChoice = Validation.checkStationControllerInput(userChoice);
        }
        return userChoice;
    }

    private static boolean registerStation(Scanner scanner) {
        OutputView.printEnterStationRegisterInstruction();
        String userInputStation = InputView.getInput(scanner);
        boolean validInput = Validation.checkRegisterStationInput(userInputStation);
        if (validInput == false) {
            return false;
        }
        Station newStation = new Station(userInputStation);
        StationRepository.addStation(newStation);
        OutputView.printInfo("지하철 역이 등록되었습니다.");
        return true;
    }

    private static boolean deleteStation(Scanner scanner) {
        OutputView.printEnterStationDeleteInstruction();
        String userInputStation = InputView.getInput(scanner);
        boolean validInput = Validation.checkDeleteStationInput(userInputStation);
        if (validInput == false) {
            return false;
        }
        StationRepository.deleteStation(userInputStation);
        OutputView.printInfo("지하철 역이 삭제되었습니다.");
        return true;
    }

    private static boolean printStation(Scanner scanner) {
        StationRepository.printStation();
        return true;
    }

}
