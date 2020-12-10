package subway.view.validator;

public class InputValidator {

    static final String NULL_ERROR = "null 값을 입력하셨습니다.";

    static String RANGE_ERROR = "이름은 2글자 이상, 8글자 이하이어야 합니다.";

    private static final int LENGTH_LOWER_BOUND = 2;

    private static final int LENGTH_UPPER_BOUND = 8;

    public void validate(String input) {
        checkNull(input);
        checkRange(input);
    }

    private void checkNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_ERROR);
        }
    }

    private void checkRange(String input) {
        int length = input.length();

        if (length < LENGTH_LOWER_BOUND || length > LENGTH_UPPER_BOUND) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }
}
