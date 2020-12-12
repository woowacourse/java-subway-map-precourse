package subway.utils;

import subway.exception.NotPositiveIntegerException;

public class ParsingUtils {
    public static int stringToPositiveInteger(String input) {
        if (!RegexUtils.isPositiveInteger(input)) {
            throw new NotPositiveIntegerException(input);
        }
        
        return Integer.parseInt(input);
    }
}
