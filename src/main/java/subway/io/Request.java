package subway.io;

import java.io.PrintStream;
import java.util.Scanner;
import subway.io.ExceptionManager.Error;
import subway.Scene;
import subway.domain.LineRepository;
import subway.domain.StationRepository;;

public class Request {
    private final Scanner scanner;
    private final PrintStream printStream;

    public Request(Scanner scanner, PrintStream printStream) {
        this.scanner = scanner;
        this.printStream = printStream;
    }

    public String requestCommand(Scene scene) {
        String input = getInput();
        Error error = ExceptionManager.checkValidCommand(scene, input);
        if (error != Error.OK) {
            printError(Error.INVALID_COMMAND);
            return null;
        }
        return input;
    }

    public boolean requestStationRegister() {
        String input = getInput();
        Error error = ExceptionManager.checkValidStationRegister(input);
        if (error != Error.OK) {
            printError(error);
            return false;
        }
        StationRepository.addStation(input);
        return true;
    }

    public boolean requestStationRemoval() {
        String input = getInput();
        Error error = ExceptionManager.checkValidStationRemoval(input);
        if (error != Error.OK) {
            printError(error);
            return false;
        }
        StationRepository.deleteStation(input);
        return true;
    }

    public String requestLineRegister() {
        String input = getInput();
        Error error = ExceptionManager.checkValidLineRegister(input);
        if (error != Error.OK) {
            printError(error);
            return null;
        }
        return input;
    }

    public boolean requestLineRemoval() {
        String input = getInput();
        Error error = ExceptionManager.checkValidLineRemoval(input);
        if (error != Error.OK) {
            printError(error);
            return false;
        }
        LineRepository.deleteLineByName(input);
        return true;
    }

    public String requestTerminatingStation() {
        String input = getInput();
        Error error = ExceptionManager.checkValidTerminatingStation(input);
        if (error != Error.OK) {
            printError(error);
            return null;
        }
        return input;
    }

    public String requestLineOfSectionRegister() {
        String input = getInput();
        Error error = ExceptionManager.checkValidLineOfSectionRegister(input);
        if (error != Error.OK) {
            printError(error);
            return null;
        }
        return input;
    }

    public String requestStationOfSectionRegister(String lineName) {
        String input = getInput();
        Error error = ExceptionManager.checkValidStationOfSectionRegister(input, lineName);
        if (error != Error.OK) {
            printError(error);
            return null;
        }
        return input;
    }

    public String requestIndexOfSectionRegister(String lineName) {
        String input = getInput();
        Error error = ExceptionManager.checkValidIndexOfSectionRegister(input, lineName);
        if (error != Error.OK) {
            printError(error);
            return null;
        }
        return input;
    }

    public String requestLineOfSectionRemoval() {
        String input = getInput();
        Error error = ExceptionManager.checkValidLineOfSectionRemoval(input);
        if (error != Error.OK) {
            printError(error);
            return null;
        }
        return input;
    }

    public String requestStationOfSectionRemoval(String lineName) {
        String input = getInput();
        Error error = ExceptionManager.checkValidStationOfSectoinRemoval(input, lineName);
        if (error != Error.OK) {
            printError(error);
            return null;
        }
        return input;
    }

    public boolean isAccessibleStationRepository() {
        Error error = ExceptionManager.checkAccessibleStationRepository();
        if (error != Error.OK) {
            printError(error);
            return false;
        }
        return true;
    }

    public boolean isAccessibleLineRepository() {
        Error error = ExceptionManager.checkAccessibleLineRepository();
        if (error != Error.OK) {
            printError(error);
            return false;
        }
        return true;
    }

    public boolean isValidTerminatingStationPair(String upboundStation, String downboundStation) {
        Error error =
                ExceptionManager.checkValidTerminatingStationPair(upboundStation, downboundStation);
        if (error != Error.OK) {
            printError(error);
            return false;
        }
        return true;
    }

    private String getInput() {
        String input = scanner.nextLine();
        printStream.println();
        return input;
    }

    private void printError(Error error) {
        printStream.printf(error.toString());
    }
}
