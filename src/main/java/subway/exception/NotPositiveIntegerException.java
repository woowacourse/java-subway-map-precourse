package subway.exception;

public class NotPositiveIntegerException extends IllegalArgumentException {
    private static final String MESSAGE = "순서는 양의 정수를 입력해주시기 바랍니다. (input: \"%s\")";

    public NotPositiveIntegerException(String input) {
        super(String.format(MESSAGE, input));
    }
}
