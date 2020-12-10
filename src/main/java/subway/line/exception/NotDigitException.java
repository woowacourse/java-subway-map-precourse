package subway.line.exception;

public class NotDigitException extends IllegalArgumentException {

    private static final String MESSAGE = "숫자만 입력 가능합니다. (입력 값: '%s')";

    public NotDigitException(final String upstreamStation) {
        super(String.format(MESSAGE, upstreamStation));
    }
}
