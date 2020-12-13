package subway.utils;

public class ParsingUtils {
    public static int stringToPositiveInteger(String input) {
        ValidationUtils.validateNotPositiveInteger(input);
        
        return Integer.parseInt(input);
    }
}
