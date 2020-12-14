package subway.view.utils;

import java.util.regex.Pattern;

public class InputValidator {
    public static final String BACK_COMMAND = "B";
    public static final String EXIT_COMMAND = "Q";
    public static final int COMMAND_LENGTH_CONVENTION = 1;
    public static final String ERROR_NOTHING = "아무것도 입력하지 않았습니다.";
    public static final String ERROR_MORE_THAN_ONE_LETTER = "한 글자만 입력해주세요.";
    public static final String ERROR_INVALID_INPUT = "선택할 수 없는 기능입니다.";

    private InputValidator() {
    }

    public static void validateMainViewInput(String pattern, String command) {
        isEmpty(command);
        isOneLetter(command);

        if (isDigit(pattern, command)) {
            return;
        }

        if (isExitCommand(command)) {
            return;
        }

        throw new IllegalArgumentException(ERROR_INVALID_INPUT);
    }

    public static void validateStationOrLineManagementViewInput(String pattern, String command) {
        isEmpty(command);
        isOneLetter(command);

        if (InputValidator.isDigit(pattern, command)) {
            return;
        }

        if (InputValidator.isBackCommand(command)) {
            return;
        }

        throw new IllegalArgumentException(ERROR_INVALID_INPUT);
    }

    public static void validateSectionManagementViewInput(String pattern, String command) {
        isEmpty(command);
        isOneLetter(command);

        if (InputValidator.isDigit(pattern, command)) {
            return;
        }

        if (InputValidator.isBackCommand(command)) {
            return;
        }

        throw new IllegalArgumentException(ERROR_INVALID_INPUT);
    }

    private static void isEmpty(String command) {
        if (command.isEmpty()) {
            throw new IllegalArgumentException(ERROR_NOTHING);
        }
    }

    private static void isOneLetter(String command) {
        if (command.length() != COMMAND_LENGTH_CONVENTION) {
            throw new IllegalArgumentException(ERROR_MORE_THAN_ONE_LETTER);
        }
    }

    private static boolean isDigit(String pattern, String command) {
        return Pattern.matches(pattern, command);
    }

    private static boolean isBackCommand(String command) {
        return command.toUpperCase().equals(BACK_COMMAND);
    }

    private static boolean isExitCommand(String command) {
        return command.toUpperCase().equals(EXIT_COMMAND);
    }

}
