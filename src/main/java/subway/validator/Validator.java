package subway.validator;

public class Validator {

    static final String NULL_ERROR = "null 값을 입력하셨습니다.";

    public void validate(final String input) {
        checkNull(input);
    }

    private void checkNull(final String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_ERROR);
        }
    }
}
