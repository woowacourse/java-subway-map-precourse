package subway.exception;

public class StationNameLengthException extends RuntimeException {

    private static final String MESSAGE = "역의 이름은 2자 이상, 5자 이하만 가능합니다. 입력값: (%s)";

    public StationNameLengthException(final String input) {
        super(String.format(MESSAGE, input));
    }
}
