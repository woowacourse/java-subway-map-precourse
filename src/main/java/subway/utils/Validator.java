package subway.utils;

public class Validator {
    private static final int MINIMUM_LEGNTH = 2;
    private static final int INDEX_START = 1;

    public static boolean isAppropriateLength(String name) {
        if (name.length() < MINIMUM_LEGNTH) {
            return false;
        }
        return true;
    }

    public static boolean isNaturalNumber(String index) {
        try {
            int number = Integer.parseInt(index);
            if (number >= INDEX_START) {
                return true;
            }
        } catch (Exception exception) {
            return false;
        }
        return false;
    }
}
