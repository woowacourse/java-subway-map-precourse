package subway.exception;

public class DuplicatedStationException extends IllegalArgumentException {
    private static final String MESSAGE = "이미 등록된 역 이름입니다. (input: \"%s\")";

    public DuplicatedStationException(String inputName) {
        super(String.format(MESSAGE, inputName));
    }
}
