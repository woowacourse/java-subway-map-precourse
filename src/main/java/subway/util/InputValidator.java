package subway.util;

import java.util.regex.Pattern;

public class InputValidator {

    final static String MAIN_MENU_INPUT_REGULAR_EXPRESS = "^[1-4qQ]{1}$";
    final static String MAIN_MENU_INPUT_ERROR = "[ERROR] 선택할 수 없는 기능 입니다.";

    public static void validateMainMenuInput(String input) throws IllegalArgumentException {
        if (!Pattern.matches(MAIN_MENU_INPUT_REGULAR_EXPRESS, input)) {
            throw new IllegalArgumentException(MAIN_MENU_INPUT_ERROR);
        }
    }
}
