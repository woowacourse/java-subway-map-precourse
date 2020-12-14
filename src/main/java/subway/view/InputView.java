package subway.view;

import java.util.IllegalFormatException;
import java.util.Scanner;

public class InputView {
    private static String command;
    //    private static final String EXIT_COMMAND = "Q";
//    private static final String BACK_COMMAND = "B";
    private static final int EXIT = -1;
    private static final int BACK = 0;
    private static final int MIN_MENU_NUMBER = 1;
    private static Screen screen;
    private static final String DIGIT_REGEX = "^[0-9]*$";

    public static int getCommand(Screen screen, Scanner scanner) {
        screen.getCommand();
        command = scanner.next().toUpperCase();
        return isCommandExitOrBackOrValid(command, screen);
    }

    private static int isCommandExitOrBackOrValid(String command, Screen screen) {
        if (command.equals(screen.getSpecialCommand())) {
            return screen.parseSpecialCommandtoInt();
        }
        return checkCommandValidate(command, screen);
    }

    // 입력 값 확인
    private static int checkCommandValidate(String command, Screen screen) {
        if (!command.matches(DIGIT_REGEX)) {
            OutputView.printInvalidCommandExceptionErrorMessage(command);
            return EXIT;
        }
        int parseCommandToInt = Integer.parseInt(command);
        if (parseCommandToInt < MIN_MENU_NUMBER || parseCommandToInt > screen.getMaxMenuNumber()) {
            OutputView.printInvalidCommandExceptionErrorMessage(command);
            return EXIT;
        }
        return parseCommandToInt;
    }

}
