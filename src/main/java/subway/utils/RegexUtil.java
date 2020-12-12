package subway.utils;

import java.util.regex.Pattern;

public class RegexUtil {
    private static final String BLANK_REGEX = "^[ 　ㅤ​]+$";

    public static boolean isBlank(String string) {
        return Pattern.matches(BLANK_REGEX, string);
    }
}
