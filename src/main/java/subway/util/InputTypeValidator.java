package subway.util;

import java.util.regex.Pattern;

public class InputTypeValidator {
    private static final String KOREAN_PATTERN = "[가-힣]*$";
    private static final String KOREAN_OR_NUMERIC = "[가-힣0-9]*$";

    private InputTypeValidator() {
    }

    public static boolean isKorean(String input) {
        return Pattern.matches(KOREAN_PATTERN, input);
    }

    public static boolean isKoreanOrNumeric(String input) {
        return Pattern.matches(KOREAN_OR_NUMERIC, input);
    }
}
