package subway.view;

import subway.view.screen.Screen;
import subway.view.screen.ScreenMapper;
import subway.view.screen.ScreenStack;

import java.util.Scanner;

public class InputView {
    private static String command;

    public static String getCommand(Scanner scanner) {
        command = scanner.next().toUpperCase();
        return command;
    }
}
