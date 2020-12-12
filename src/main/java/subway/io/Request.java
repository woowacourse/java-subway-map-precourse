package subway.io;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import subway.io.ExceptionManager.Error;
import subway.Scene;

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

    public boolean applyInput(Function<String, Error> checkValidation, Consumer<String> objective) {
        String input = getInput();
        Error error = checkValidation.apply(input);
        if (error != Error.OK) {
            printError(error);
            return false;
        }
        objective.accept(input);
        return true;
    }

    public String requestInput(Function<String, Error> checkValidation) {
        String input = getInput();
        Error error = checkValidation.apply(input);
        if (error != Error.OK) {
            printError(error);
            return null;
        }
        return input;
    }

    public String requestInputInLine(BiFunction<String, String, Error> checkValidation,
            String lineName) {
        String input = getInput();
        Error error = checkValidation.apply(input, lineName);
        if (error != Error.OK) {
            printError(error);
            return null;
        }
        return input;
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
