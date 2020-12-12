package subway.view;

import java.util.List;
import java.util.Scanner;
import subway.message.Message;
import subway.message.Output;

/**
 * @author yhh1056
 * @since 2020/12/10
 */
public class Input {
    private static final String REGEX = "\\p{Z}";
    private static final String REPLACEMENT = "";
    private static final int STATION_NAME_LENGTH = 2;
    private static final String STATION_END_NAME = "역";
    private static final String SELECT_FEATURE = "\n## 원하는 기능을 선택하세요.";

    private final Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public String nextButton(List<String> buttons) {
        String button = toUpperNextLine();
        while (!buttons.contains(button)) {
            Message.printError();
            Output.printLine(SELECT_FEATURE);
            button = toUpperNextLine();
        }
        return button;
    }

    private String toUpperNextLine() {
        return nextLine().toUpperCase();
    }

    private String nextLine() {
        return scanner.nextLine().replaceAll(REGEX, REPLACEMENT);
    }

    public String nextStation() {
        return nextLine();
    }

    public boolean validName(String name) {
        if (name.length() < STATION_NAME_LENGTH) {
            Message.printNameLengthError();
            return false;
        }
        if (!name.endsWith(STATION_END_NAME)) {
            Message.printNameError();
            return false;
        }
        return true;
    }
}
