package subway.view;

import java.util.Scanner;

public class InputView {
    private static final String BLANK = " ";
    private static final String EMPTY = "";

    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public char selectOption() {
        return scanner.next().charAt(0);
    }

    public String stationName() {
        String station = scanner.next();
        return station.replaceAll(BLANK, EMPTY);
    }

    public String lineName() {
        String line = scanner.next();
        return line.replaceAll(BLANK, EMPTY);
    }

    public String sectionNumber() {
        return scanner.next();
    }
}
