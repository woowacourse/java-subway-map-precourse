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
        return nextLine();
    }

    public String nextStationButton() {
        Message.printStatinMenu();
        return nextLine();
    }

    public String nextLineButton() {
        Message.printLineMenu();
        return nextLine();
    }

    public String nextSectionButton() {
        Message.printSectionMenu();
        return nextLine();
    }

    private String nextLine() {
        return scanner.nextLine();
    }
}
