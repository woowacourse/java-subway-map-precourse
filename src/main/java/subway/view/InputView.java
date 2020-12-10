package subway.view;

import java.util.Scanner;
import subway.CategoryType;
import subway.line.exception.NotDigitException;
import subway.view.exception.InvalidCommandException;
import subway.view.screen.MainScreen;

public final class InputView {

    public static final String ONLY_DIGIT_REGULAR = "^[0-9]*$";
    public static final int MIN_LIST_NUMBER = 1;
    public static final String EXIT_COMMAND = "q";
    public static final String BACK_COMMAND = "b";
    public static final int EXIT = -1;
    public static final int BACK = -1;

    private final Scanner scanner;

    private InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public static InputView of(final Scanner scanner) {
        return new InputView(scanner);
    }

    public int readCategoryCommandNumber() {
        String command = readCommand().toLowerCase();

        if (command.equals(InputView.EXIT_COMMAND)) {
            return EXIT;
        }

        return converToNumber(command, MainScreen.MAIN_CATEGORIES.size());
    }

    public int readActionOrderCommandNumber(CategoryType selectedCategoryType) {
        String command = readCommand().toLowerCase();

        if (command.equals(InputView.BACK_COMMAND)) {
            return BACK;
        }

        return converToNumber(command, selectedCategoryType.getActionOrder().size());
    }

    private int converToNumber(String command, int listSize) {
        if (!command.matches(InputView.ONLY_DIGIT_REGULAR) || command.isEmpty()) {
            throw new InvalidCommandException(command);
        }

        int commandNumber = Integer.parseInt(command);
        if (commandNumber < MIN_LIST_NUMBER || commandNumber > listSize) {
            throw new InvalidCommandException(command);
        }

        return commandNumber;
    }

    public int readLineIndex() {
        String command = readCommand().toLowerCase();

        if (!command.matches(InputView.ONLY_DIGIT_REGULAR) || command.isEmpty()) {
            throw new NotDigitException(command);
        }

        return Integer.parseInt(command);
    }

    public String readCommand() {
        return scanner.nextLine();
    }
}
