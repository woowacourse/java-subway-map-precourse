package subway.utils;

public class InputValidator {
    private static final String INCORRECT_NUMBER_ERROR = "[ERROR] 순서는 숫자로 입력해주세요.";


    private InputValidator() {

    }

    public static int validateInteger(String index) {
        try {
            return Integer.parseInt(index);
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INCORRECT_NUMBER_ERROR);
        }
    }
}
