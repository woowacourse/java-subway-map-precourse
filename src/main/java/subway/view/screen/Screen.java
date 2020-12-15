package subway.view.screen;

import subway.view.OutputView;

import java.util.Scanner;

public interface Screen {
    public static final String SPACE = " ";
    public static final String EXIT_MARK = "Q. ";
    public static final String BACK_MARK = "B. ";
    public static final String DOT = ". ";
    public static final String DIGIT_REGEX = "^[0-9]*$";
    public static final int MIN_MENU_NUMBER = 1;
    public static final int ERROR = -1;


    void show();

    void run(Scanner scanner);

    default int isCommandValidate(String command, int MAX_MENU_NUMBER) {
        if (!command.matches(DIGIT_REGEX)) {
            OutputView.printInvalidCommandExceptionErrorMessage(command);
            return ERROR;
        }
        int parseCommandToInt = Integer.parseInt(command);
        if (parseCommandToInt < MIN_MENU_NUMBER || parseCommandToInt > MAX_MENU_NUMBER) {
            OutputView.printInvalidCommandExceptionErrorMessage(command);
            return ERROR;
        }
        return parseCommandToInt;
    }
}
