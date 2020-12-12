package subway.line.exception;

public class OutOfRangeOfLineException extends IllegalArgumentException {

    private static final String MESSAGE = "노선의 범위를 벗어났습니다. (입력 값: '%d')";

    public OutOfRangeOfLineException(final int input) {
        super(String.format(MESSAGE, input));
    }
}
