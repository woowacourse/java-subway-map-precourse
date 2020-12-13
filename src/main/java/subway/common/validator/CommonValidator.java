package subway.common.validator;

public class CommonValidator {
    public static final int MIN_LENGTH = 2;

    public static boolean isLengthLessThanMinLength(String inputStr) {
        return inputStr.length() < MIN_LENGTH;
    }
}
