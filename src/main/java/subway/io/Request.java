package subway.io;

import java.io.PrintStream;
import java.util.Scanner;
import subway.Scene;

public class Request {
    private final Scanner scanner;
    private final PrintStream printStream;

    public Request(Scanner scanner, PrintStream printStream) {
        this.scanner = scanner;
        this.printStream = printStream;
    }

    public String requestCommand(Scene scene) {
        String input = scanner.nextLine();
        if (!scene.hasCommand(input)) {
            printError(Error.INVALID_COMMAND);
            return null;
        }
        return input;
    }

    private void printError(Error error) {
        printStream.println(error.toString());
    }
}
