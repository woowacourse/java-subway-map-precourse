package subway.view;

import java.util.Scanner;

public class InputView {
    private static String command;

    public static String getCommand(Scanner scanner) {
        command = scanner.next().toUpperCase();
        return command;
    }
}
