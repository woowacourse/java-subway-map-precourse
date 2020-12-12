package subway.util;

public class InputUtils {

    public static boolean isValidateInt(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            if (!Character.isDigit(inputString.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPositiveInt(int inputInt) {
        if (inputInt <= 0) {
            return false;
        }
        return true;
    }

    public static boolean isMinLengthString(String inputString) {
        return inputString.length() >= Constants.MIN_NAME_STRING_LENGTH;
    }
}
