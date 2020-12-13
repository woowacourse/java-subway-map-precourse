package subway.view;

import static subway.message.Output.printLine;

import java.util.List;
import java.util.Scanner;
import subway.message.Message;

/**
 * @author yhh1056
 * @since 2020/12/10
 */
public class Input {
    private static final String REGEX = "\\p{Z}";
    private static final String REPLACEMENT = "";
    private static final int STATION_NAME_LENGTH = 2;
    private static final String STATION_END_NAME = "역";

    private final Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public String nextButton(List<String> buttons) {
        String button = toUpper(nextLine());
        while (!buttons.contains(button)) {
            printLine(Message.ERROR_NOT_BUTTON);
            printLine(Message.INPUT_SELECT_BUTTON);
            button = toUpper(nextLine());
        }
        return button;
    }

    public boolean validName(String name) {
        if (!validNameLength(name)) {
            printLine(Message.ERROR_NAME_LENGTH);
            return false;
        }
        if (!validNameEndWord(name)) {
            printLine(Message.ERROR_NAME_END);
            return false;
        }
        return true;
    }

    private boolean validNameLength(String name) {
        return name.length() >= STATION_NAME_LENGTH;
    }

    private boolean validNameEndWord(String name) {
        return name.endsWith(STATION_END_NAME);
    }

    private String toUpper(String input) {
        return input.toUpperCase();
    }

    private String nextLine() {
        return scanner.nextLine().replaceAll(REGEX, REPLACEMENT);
    }

    public String nextStation() {
        return nextLine();
    }
}
