package subway.util;

import java.util.regex.Pattern;

public class InputTypeValidator {
    private static final String KOREAN_PATTERN = "[가-힣]*$";

    private InputTypeValidator() {
    }

    public static boolean isKorean(String input) {
        return Pattern.matches(KOREAN_PATTERN, input);
    }
}
