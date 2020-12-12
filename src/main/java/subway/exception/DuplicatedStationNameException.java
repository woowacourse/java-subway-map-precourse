package subway.exception;

public class DuplicatedStationNameException extends IllegalArgumentException {
    private static final String MESSAGE = "이미 등록된 역 이름입니다. (input: \"%s\")";

    public DuplicatedStationNameException(String inputName) {
        super(String.format(MESSAGE, inputName));
    }
}
