package subway.util;

public class InputUtils {

    public static int parsePositiveIntOrThrow(String inputString) {
        try {
            int num = Integer.parseInt(inputString);
            if (num <= 0) {
                throw new RuntimeException(Constants.INVALID_INDEX);
            }
            return num;
        } catch (NumberFormatException e) {
            throw new RuntimeException(Constants.INVALID_STRING);
        }
    }

    public static void checkMinLengthOrThrow(String inputString) {
        if (inputString.length() < Constants.MIN_NAME_STRING_LENGTH_INT) {
            throw new RuntimeException(Constants.INVALID_STRING_MIN_LENGTH);
        }
    }
}
