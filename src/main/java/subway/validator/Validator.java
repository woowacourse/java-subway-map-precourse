package subway.validator;

public class Validator {

    static final String NULL_ERROR = "null 값을 입력하셨습니다.";

    public void validate(String input) {
        checkNull(input);
    }

    private void checkNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_ERROR);
        }
    }
}
