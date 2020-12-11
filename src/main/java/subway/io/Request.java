package subway.io;

import java.io.PrintStream;
import java.util.Scanner;
import subway.Scene;
import subway.domain.Station;
import subway.domain.StationRepository;

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

    public boolean requestStationRegister() {
        String input = scanner.nextLine();
        if (input.length() < Station.MINIMUM_NAME_LENGTH) {
            printError(Error.INVALID_STATION_NAME_LENGTH);
            return false;
        }
        if (StationRepository.hasStation(input)) {
            printError(Error.DUPLICATE_STATION_NAME);
            return false;
        }
        StationRepository.addStation(input);
        return true;
    }

    private void printError(Error error) {
        printStream.println(error.toString());
    }
}
