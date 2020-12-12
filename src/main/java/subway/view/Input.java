package subway.view;

import java.util.Scanner;

/**
 * @author yhh1056
 * @since 2020/12/10
 */
public class Input {
    private static final String REGEX = "\\p{Z}";
    private static final String REPLACEMENT = "";

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
        Message.printSelectFeature();
        return nextMainButton();
    }

    public String nextStationButton() {
        String button = toUpperNextLine();
        if (Button.containsStationButtons(button)) {
            return button;
        }
        Message.printError();
        Message.printSelectFeature();
        return nextStationButton();
    }

    public String nextLineButton() {
        String button = toUpperNextLine();
        if (Button.containsLineButtons(button)) {
            return button;
        }
        Message.printError();
        Message.printSelectFeature();
        return nextLineButton();
    }

    public String nextSectionButton() {
        String button = toUpperNextLine();
        if (Button.containsSectionButtons(button)) {
            return button;
        }
        Message.printError();
        Message.printSelectFeature();
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
}
