package subway.exception;

public class NotPositiveIntegerException extends IllegalArgumentException {
    private static final String MESSAGE = "순서는 양의 정수여야 합니다. (input: \"%s\")";

    public NotPositiveIntegerException(String input) {
        super(String.format(MESSAGE, input));
    }
}
