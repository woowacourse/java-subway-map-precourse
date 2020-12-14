package subway.util;

public class InputUtils {

    public static int getPositiveIntOrThrow(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            if (!Character.isDigit(inputString.charAt(i))) {
                throw new RuntimeException(Constants.INVALID_STRING);
            }
        }
        int refinedInt = Integer.parseInt(inputString);
        if (refinedInt <= 0) {
            throw new RuntimeException(Constants.INVALID_INDEX);
        }
        return refinedInt;
    }

    public static void isMinLengthString(String inputString) {
        if (inputString.length() < Constants.MIN_NAME_STRING_LENGTH_INT) {
            throw new RuntimeException(Constants.INVALID_STRING_MIN_LENGTH);
        }
    }
}
