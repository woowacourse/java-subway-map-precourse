package subway.exception;

import subway.CommonConstants;
import subway.screen.Screen;

public class Validator {
    private static String ERROR_MESSAGE_PREFIX = "[ERROR]";
    private static String INVALID_USER_COMMAND_MESSAGE = "선택할 수 없는 기능입니다.";

    public static void checkValidUserCommand(String userCommand, Screen screen) {
        if (!screen.containsCommand(userCommand)) {
            throw new IllegalArgumentException(
                    ERROR_MESSAGE_PREFIX + CommonConstants.SPACE + INVALID_USER_COMMAND_MESSAGE);
        }
    }
}
