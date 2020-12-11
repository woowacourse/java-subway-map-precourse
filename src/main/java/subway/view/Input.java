package subway.view;

import java.util.Scanner;

/**
 * @author yhh1056
 * @since 2020/12/10
 */
public class Input {
    private final Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public String nextMainButton() {
        Message.printMainMenu();
        return toUpperNextLine();
    }

    public String nextStationButton() {
        Message.printStatinMenu();
        return toUpperNextLine();
    }

    public String nextLineButton() {
        Message.printLineMenu();
        return toUpperNextLine();
    }

    public String nextSectionButton() {
        Message.printSectionMenu();
        return toUpperNextLine();
    }

    private String toUpperNextLine() {
        return nextLine().toUpperCase();
    }

    private String nextLine() {
        return scanner.nextLine();
    }
}
