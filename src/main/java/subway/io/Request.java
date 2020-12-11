package subway.io;

import java.io.PrintStream;
import java.util.Scanner;
import subway.io.ExceptionManager.Error;
import subway.Scene;
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

    public boolean isAccessibleStationRepository() {
        Error error = ExceptionManager.checkAccessibleStationRepository();
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
