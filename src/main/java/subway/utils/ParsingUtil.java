package subway.utils;

import subway.exception.NotPositiveIntegerException;

public class ParsingUtil {
    public static int stringToPositiveInteger(String string) {
        if (!RegexUtil.isPositiveInteger(string)) {
            throw new NotPositiveIntegerException(string);
        }
        
        return Integer.parseInt(string);
    }
}
