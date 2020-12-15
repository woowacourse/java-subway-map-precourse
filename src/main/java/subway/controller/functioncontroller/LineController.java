package subway.controller.functioncontroller;

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

public class LineController extends FunctionController {
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
        if (userChoice.equals(REGISTER)) {
            return registerLine(scanner);
        }
        if (userChoice.equals(DELETE)) {
            return deleteLine(scanner);
        }
        if (userChoice.equals(PRINT)) {
            return printLine(scanner);
        }
        if (userChoice.equals(BACK)) {
            return true;
        }
        return false;
    }

    private static boolean registerLine(Scanner scanner) {
        String userInputLine = getRegisterLineUserInputLine(scanner);
        if (userInputLine.equals(INVALID_INPUT)) {
            return false;
        }
        String upTerminusInput = getRegisterUserInputUpTerminus(scanner);
        if (upTerminusInput.equals(INVALID_INPUT)) {
            return false;
        }
        String downTerminusInput = getRegisterUserInputDownTerminus(scanner);
        if (downTerminusInput.equals(INVALID_INPUT) ||
                !LineValidation.checkSameTerminus(upTerminusInput, downTerminusInput)) {
            return false;
        }
        registerLineToDataBase(userInputLine, upTerminusInput, downTerminusInput);
        return true;
    }

    private static String getRegisterLineUserInputLine(Scanner scanner) {
        LineOutputView.printLineRegisterInstruction();
        String userInputLine = InputView.getInput(scanner);
        if (!LineValidation.checkRegisterLineInput(userInputLine)) {
            return INVALID_INPUT;
        }
        return userInputLine;
    }

    private static String getRegisterUserInputUpTerminus(Scanner scanner) {
        LineOutputView.printUpTerminusInstruction();
        String TerminusInput = InputView.getInput(scanner);
        if (!StationValidation.checkIsInStationRepository(TerminusInput)) {
            return INVALID_INPUT;
        }
        return TerminusInput;
    }

    private static String getRegisterUserInputDownTerminus(Scanner scanner) {
        LineOutputView.printDownTerminusInstruction();
        String TerminusInput = InputView.getInput(scanner);
        if (!StationValidation.checkIsInStationRepository(TerminusInput)) {
            return INVALID_INPUT;
        }
        return TerminusInput;
    }

    private static void registerLineToDataBase(String userInputLine, String upTerminusInput, String downTerminusInput) {
        Line newLine = new Line(userInputLine);
        Station upTerminus = StationRepository.getStationByName(upTerminusInput);
        Station downTerminus = StationRepository.getStationByName(downTerminusInput);
        upTerminus.addBelongToWhichLine(newLine);
        downTerminus.addBelongToWhichLine(newLine);
        newLine.addStationsInLine(upTerminus);
        newLine.addStationsInLine(downTerminus);
        LineRepository.addLine(newLine);
        LineInfoView.printRegisterInfo();
    }

    private static boolean deleteLine(Scanner scanner) {
        String userInputLine = getDeleteLineUserInput(scanner);
        if (userInputLine.equals(INVALID_INPUT)) {
            return false;
        }
        deleteLineFromDataBase(userInputLine);
        return true;
    }

    private static String getDeleteLineUserInput(Scanner scanner) {
        LineOutputView.printLineDeleteInstruction();
        String userInputLine = InputView.getInput(scanner);
        if (!LineValidation.checkDeleteLineInput(userInputLine)) {
            return INVALID_INPUT;
        }
        return userInputLine;
    }

    private static void deleteLineFromDataBase(String userInputLine) {
        LineRepository.deleteLineByName(userInputLine);
        LineInfoView.printDeleteInfo();
    }

    private static boolean printLine(Scanner scanner) {
        LineOutputView.printLineList();
        LineInfoView.printLine();
        return true;
    }
}
