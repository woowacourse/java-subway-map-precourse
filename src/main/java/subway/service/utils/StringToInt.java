package subway.service.utils;

public class StringToInt {
    public static final String ERROR_NOT_NATURAL_NUMBER = "숫자를 입력해주세요.";

    private StringToInt() {
    }

    public static int convertToInt(String number) {
        validateNaturalNumber(number);
        return Integer.parseInt(number);
    }

    private static void validateNaturalNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_NATURAL_NUMBER);
        }
    }
}
