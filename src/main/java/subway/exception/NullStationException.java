package subway.exception;

public class NullStationException extends IllegalArgumentException {
    private static final String MESSAGE = "해당 역은 존재하지 않습니다. (input: \"%s\")";

    public NullStationException(String inputName) {
        super(String.format(MESSAGE, inputName));
    }
}
