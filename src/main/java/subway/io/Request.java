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

    // validation으로 받은 함수를 통해 예외사항을 확인하고 objective 함수를 입력받은 값으로 적용시킨다.
    public boolean applyInput(Function<String, Error> validation, Consumer<String> objective) {
        String input = getInput();
        Error error = validation.apply(input);
        if (error != Error.OK) {
            printError(error);
            return false;
        }
        objective.accept(input);
        return true;
    }

    // validation으로 받은 함수를 통해 예외사항을 확인하고 문제가 없을 때만 그 입력값을 반환한다.
    public String requestInput(Function<String, Error> validation) {
        String input = getInput();
        Error error = validation.apply(input);
        if (error != Error.OK) {
            printError(error);
            return null;
        }
        return input;
    }

    // validation으로 받은 함수를 통해 현재 노선에서의 예외사항을 확인하고 문제가 없을 때만 그 입력값을 반환한다.
    public String requestInputInLine(BiFunction<String, String, Error> validation,
            String lineName) {
        String input = getInput();
        Error error = validation.apply(input, lineName);
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
