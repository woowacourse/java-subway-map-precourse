package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.validator.LineValidation;
import subway.validator.StationValidation;
import subway.view.InputView;
import subway.view.lineoutput.LineInfoView;
import subway.view.lineoutput.LineOutputView;

import java.util.Scanner;

public class LineController {
    private static final String LINE_REGISTER = "1";
    private static final String LINE_DELETE = "2";
    private static final String LINE_PRINT = "3";
    private static final String BACK = "B";

    public static void start(Scanner scanner) {
        runLineController(scanner);
    }

    private static void runLineController(Scanner scanner) {
        String userChoice = "";
        boolean lineControllerDone = false;
        while (!lineControllerDone) {
            LineOutputView.printOption();
            userChoice = getUserChoice(scanner);
            lineControllerDone = startChosenLineFunction(userChoice, scanner);
        }
    }

    private static String getUserChoice(Scanner scanner) {
        String userChoice = null;
        boolean validChoice = false;
        while (!validChoice) {
            LineOutputView.printOptionInstruction();
            userChoice = InputView.getInput(scanner);
            validChoice = LineValidation.checkControllerInput(userChoice);
        }
        return userChoice;
    }

    private static boolean startChosenLineFunction(String userChoice, Scanner scanner) {
        if (userChoice.equals(LINE_REGISTER)) {
            return registerLine(scanner);
        }
        if (userChoice.equals(LINE_DELETE)) {
            return deleteLine(scanner);
        }
        if (userChoice.equals(LINE_PRINT)) {
            return printLine(scanner);
        }
        if (userChoice.equals(BACK)) {
            return true;
        }
        return false;
    }

    private static boolean registerLine(Scanner scanner) {
        LineOutputView.printLineRegisterInstruction();
        String userInputLine = InputView.getInput(scanner);
        boolean validInput = LineValidation.checkRegisterLineInput(userInputLine);
        if (!validInput) {
            return false;
        }

        LineOutputView.printUpTerminusInstruction();
        String upTerminusInput = InputView.getInput(scanner);
        validInput = StationValidation.checkIsInStationRepository(upTerminusInput);
        if (!validInput) {
            return false;
        }

        LineOutputView.printDownTerminusInstruction();
        String downTerminusInput = InputView.getInput(scanner);
        validInput = StationValidation.checkIsInStationRepository(downTerminusInput);
        if (!validInput) {
            return false;
        }

        validInput = LineValidation.checkSameTerminus(upTerminusInput, downTerminusInput);
        if (!validInput) {
            return false;
        }

        Line newLine = new Line(userInputLine);
        Station upTerminus = StationRepository.getStationByName(upTerminusInput);
        Station downTerminus = StationRepository.getStationByName(downTerminusInput);
        upTerminus.addBelongToWhichLine(newLine);
        downTerminus.addBelongToWhichLine(newLine);
        newLine.addStationsInLine(upTerminus);
        newLine.addStationsInLine(downTerminus);
        LineRepository.addLine(newLine);
        LineInfoView.printRegisterInfo();
        return true;
    }

    private static boolean deleteLine(Scanner scanner) {
        LineOutputView.printLineDeleteInstruction();
        String userInputLine = InputView.getInput(scanner);
        boolean validInput = LineValidation.checkDeleteLineInput(userInputLine);
        if (!validInput) {
            return false;
        }
        LineRepository.deleteLineByName(userInputLine);
        LineInfoView.printDeleteInfo();
        return true;
    }

    private static boolean printLine(Scanner scanner) {
        LineOutputView.printLineList();
        LineInfoView.printLine();
        return true;
    }
}
