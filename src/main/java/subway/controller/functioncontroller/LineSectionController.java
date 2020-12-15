package subway.controller.functioncontroller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.validator.LineSectionValidation;
import subway.validator.LineValidation;
import subway.view.InputView;
import subway.view.linesectionoutput.LineSectionInfoView;
import subway.view.linesectionoutput.LineSectionOutputView;

import java.util.Scanner;

public class LineSectionController extends FunctionController {
    public static void start(Scanner scanner) {
        runLineSectionController(scanner);
    }

    private static void runLineSectionController(Scanner scanner) {
        String userChoice = "";
        boolean lineSectionControllerDone = false;
        while (!lineSectionControllerDone) {
            LineSectionOutputView.printOption();
            userChoice = getUserChoice(scanner);
            lineSectionControllerDone = startChosenLineSectionFunction(userChoice, scanner);
        }
    }

    private static String getUserChoice(Scanner scanner) {
        String userChoice = null;
        boolean validChoice = false;
        while (!validChoice) {
            LineSectionOutputView.printOptionInstruction();
            userChoice = InputView.getInput(scanner);
            validChoice = LineSectionValidation.checkControllerInput(userChoice);
        }
        return userChoice;
    }

    private static boolean startChosenLineSectionFunction(String userChoice, Scanner scanner) {
        if (userChoice.equals(REGISTER)) {
            return registerLineSection(scanner);
        }
        if (userChoice.equals(DELETE)) {
            return deleteLineSection(scanner);
        }
        if (userChoice.equals(BACK)) {
            return true;
        }
        return false;
    }

    private static boolean registerLineSection(Scanner scanner) {
        String userInputLine = getRegisterLineSectionUserInputLine(scanner);
        if (userInputLine.equals(INVALID_INPUT)) {
            return false;
        }
        String userInputStation = getRegisterLineSectionUserInputStation(scanner, userInputLine);
        if (userInputStation.equals(INVALID_INPUT)) {
            return false;
        }
        String userInputOrder = getRegisterLineSectionUserInputOrder(scanner, userInputLine);
        if (userInputOrder.equals(INVALID_INPUT)) {
            return false;
        }
        registerLineSectionToDataBase(userInputLine, userInputStation, userInputOrder);
        return true;
    }

    private static String getRegisterLineSectionUserInputLine(Scanner scanner) {
        LineSectionOutputView.printLineSectionRegisterLineNameInstruction();
        String userInputLine = InputView.getInput(scanner);
        if (!LineValidation.checkIsInLineRepository(userInputLine)) {
            return INVALID_INPUT;
        }
        return userInputLine;
    }

    private static String getRegisterLineSectionUserInputStation(Scanner scanner, String userInputLine) {
        LineSectionOutputView.printLineSectionRegisterStationNameInstruction();
        String userInputStation = InputView.getInput(scanner);
        if (!LineSectionValidation.checkAvailableStationToRegister(userInputLine, userInputStation)) {
            return INVALID_INPUT;
        }
        return userInputStation;
    }

    private static String getRegisterLineSectionUserInputOrder(Scanner scanner, String userInputLine) {
        LineSectionOutputView.printLineSectionRegisterOrderInstruction();
        String userInputOrder = InputView.getInput(scanner);
        if (!LineSectionValidation.checkAvailableOrderToRegister(userInputLine, userInputOrder)) {
            return INVALID_INPUT;
        }
        return userInputOrder;
    }

    private static void registerLineSectionToDataBase(String userInputLine, String userInputStation, String userInputOrder) {
        Line registerLine = LineRepository.getLineByName(userInputLine);
        Station sectionStation = StationRepository.getStationByName(userInputStation);
        int order = Integer.parseInt(userInputOrder);
        sectionStation.addBelongToWhichLine(registerLine);
        registerLine.updateStationsInLine(order, sectionStation);
        LineSectionInfoView.printRegisterInfo();
    }

    private static boolean deleteLineSection(Scanner scanner) {
        String userInputLine = getDeleteLineSectionUserInputLine(scanner);
        if(userInputLine.equals(INVALID_INPUT)) {
            return false;
        }
        String userInputStation = getDeleteLineSectionUserInputStation(scanner, userInputLine);
        if(userInputStation.equals(INVALID_INPUT)) {
            return false;
        }
        deleteLineSectionFromDataBase(userInputLine, userInputStation);
        return true;
    }

    private static String getDeleteLineSectionUserInputLine(Scanner scanner) {
        LineSectionOutputView.printLineSectionDeletionLineNameInstruction();
        String userInputLine = InputView.getInput(scanner);
        if(!LineSectionValidation.checkAvailableLineForDeletion(userInputLine)){
            return INVALID_INPUT;
        }
        return userInputLine;
    }

    private static String getDeleteLineSectionUserInputStation(Scanner scanner, String userInputLine) {
        LineSectionOutputView.printLineSectionDeletionStationNameInstruction();
        String userInputStation = InputView.getInput(scanner);
        if(!LineSectionValidation.checkAvailableStationForDeletion(userInputLine, userInputStation)){
            return INVALID_INPUT;
        }
        return userInputStation;
    }

    private static void deleteLineSectionFromDataBase(String userInputLine, String userInputStation) {
        Line registerLine = LineRepository.getLineByName(userInputLine);
        Station sectionStation = StationRepository.getStationByName(userInputStation);
        registerLine.deleteStationsInLine(sectionStation);
        sectionStation.deleteBelongToWhichLine(registerLine);
        LineSectionInfoView.printDeleteInfo();
    }
}
