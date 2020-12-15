package subway.utils;

import java.util.regex.Pattern;

public class RegexUtils {
    private static final String POSITIVE_INTEGER_REGEX = "^[0-9]*[1-9]+[0-9]*$";

    public static boolean isPositiveInteger(String input) {
        return Pattern.matches(POSITIVE_INTEGER_REGEX, input);
    }
}
