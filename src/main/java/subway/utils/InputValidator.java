package subway.utils;

public class InputValidator {

    private static final String MENU_SELECTION_ERROR = "[ERROR] 선택할 수 없는 기능입나다.";
    private static final String INPUT_TWO_MORE_WORDS_ERROR = "[ERROR] 입력값은 두 글자이상이여야 합니다.";
    private static final String INPUT_POSITIVE_NUMBER_ERROR = "[ERROR] 입력값은 0보다 큰 양수이여야 합니다.";

    private InputValidator() {}

    public static void validateMenuInput(String input, int range) {
        validateIntegerAndInRange(input, range);
    }

    private static void validateIntegerAndInRange(String input, int range) {
        try {
            int integerInput = Integer.parseInt(input);
            if (integerInput <= 0 || integerInput > range) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(MENU_SELECTION_ERROR);
        }
    }

    public static void validateMoreThanTwoWords(String input) {
        int inputLength = input.length();
        if (inputLength <= 2) {
            throw new IllegalArgumentException(INPUT_TWO_MORE_WORDS_ERROR);
        }
    }

    public static void validatePositiveNumber(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(INPUT_POSITIVE_NUMBER_ERROR);
        }
    }
}
