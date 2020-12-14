package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.validator.LineSectionValidation;
import subway.validator.LineValidation;
import subway.validator.StationValidation;
import subway.view.InputView;
import subway.view.lineoutput.LineInfoView;
import subway.view.lineoutput.LineOutputView;
import subway.view.linesectionoutput.LineSectionInfoView;
import subway.view.linesectionoutput.LineSectionOutputView;

import java.util.Scanner;

public class LineSectionController {
    private static final String LINE_SECTION_REGISTER = "1";
    private static final String LINE_SECTION_DELETE = "2";
    private static final String BACK = "B";

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
        if (userChoice.equals(LINE_SECTION_REGISTER)) {
            return registerLineSection(scanner);
        }
        if (userChoice.equals(LINE_SECTION_DELETE)) {
            return deleteLineSection(scanner);
        }
        if (userChoice.equals(BACK)) {
            return true;
        }
        return false;
    }

    private static boolean registerLineSection(Scanner scanner) {
        LineSectionOutputView.printLineSectionRegisterLineNameInstruction();
        String userInputLine = InputView.getInput(scanner);
        boolean validInput = LineValidation.checkIsInLineRepository(userInputLine);
        if (!validInput) {
            return false;
        }

        LineSectionOutputView.printLineSectionRegisterStationNameInstruction();
        String userInputStation = InputView.getInput(scanner);
        validInput = LineSectionValidation.checkAvailableStation(userInputLine, userInputStation);
        if (!validInput) {
            return false;
        }

        LineSectionOutputView.printLineSectionRegisterOrderInstruction();
        String userInputOrder = InputView.getInput(scanner);
        validInput = LineSectionValidation.checkAvailableOrder(userInputLine, userInputOrder);
        if (!validInput) {
            return false;
        }

        Line registerLine = LineRepository.getLineByName(userInputLine);
        Station sectionStation =  StationRepository.getStationByName(userInputStation);
        int order = Integer.parseInt(userInputOrder);
        sectionStation.addBelongToWhichLine(registerLine);
        registerLine.getStationsInLine().add(order-1, sectionStation);
        LineSectionInfoView.printRegisterInfo();
        return true;
    }

    private static boolean deleteLineSection(Scanner scanner) {
        LineSectionOutputView.printLineSectionDeletionLineNameInstruction();
        String userInputLine = InputView.getInput(scanner);
        boolean validInput = LineSectionValidation.checkAvailableLineForDeletion(userInputLine);
        if (!validInput) {
            return false;
        }

        LineSectionOutputView.printLineSectionDeletionStationNameInstruction();
        String userInputStation = InputView.getInput(scanner);
        validInput = LineSectionValidation.checkAvailableStationForDeletion(userInputLine, userInputStation);
        if (!validInput) {
            return false;
        }

        Line registerLine = LineRepository.getLineByName(userInputLine);
        Station sectionStation =  StationRepository.getStationByName(userInputStation);
        registerLine.deleteStationsInLine(sectionStation);
        sectionStation.deleteBelongToWhichLine(registerLine);
        LineSectionInfoView.printDeleteInfo();
        return true;
    }
}
