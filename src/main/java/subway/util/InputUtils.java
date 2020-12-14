package subway.util;

public class InputUtils {

    public static int getPositiveIntOrThrow(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            if (!Character.isDigit(inputString.charAt(i))) {
                throw new RuntimeException(Constants.INVALID_STRING_ERROR_COMMENT);
            }
        }
        int refinedInt = Integer.parseInt(inputString);
        if (refinedInt <= 0) {
            throw new RuntimeException(Constants.INVALID_LENGTH_ERROR_COMMENT);
        }
        return refinedInt;
    }

    public static void isMinLengthString(String inputString) {
        if (inputString.length() < Constants.MIN_NAME_STRING_LENGTH) {
            throw new RuntimeException(Constants.INVALID_MIN_LENGTH_ERROR_COMMENT);
        }
    }
}
