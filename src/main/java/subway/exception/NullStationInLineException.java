package subway.exception;

public class NullStationInLineException extends IllegalArgumentException {
    private static final String MESSAGE = "이 노선에 해당 역은 존재하지 않습니다. (input: \"%s\")";

    public NullStationInLineException(String inputName) {
        super(String.format(MESSAGE, inputName));
    }
}
