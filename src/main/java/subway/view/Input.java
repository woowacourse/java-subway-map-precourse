package subway.view;

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

    public String nextMainButton() {
        String button = toUpperNextLine();
        if (Button.containsMainButton(button)) {
            return button;
        }
        Message.printError();
        Output.printLine(SELECT_FEATURE);
        return nextMainButton();
    }

    public String nextStationButton() {
        String button = toUpperNextLine();
        if (Button.containsStationButtons(button)) {
            return button;
        }
        Message.printError();
        Output.printLine(SELECT_FEATURE);
        return nextStationButton();
    }

    public String nextLineButton() {
        String button = toUpperNextLine();
        if (Button.containsLineButtons(button)) {
            return button;
        }
        Message.printError();
        Output.printLine(SELECT_FEATURE);
        return nextLineButton();
    }

    public String nextSectionButton() {
        String button = toUpperNextLine();
        if (Button.containsSectionButtons(button)) {
            return button;
        }
        Message.printError();
        Output.printLine(SELECT_FEATURE);
        return nextSectionButton();
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
