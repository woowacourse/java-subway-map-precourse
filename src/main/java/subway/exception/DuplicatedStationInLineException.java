package subway.exception;

public class DuplicatedStationInLineException extends IllegalArgumentException {
    private static final String MESSAGE = "한 노선에 동일한 역을 여러 번 등록할 수 없습니다. (input: \"%s\")";

    public DuplicatedStationInLineException(String inputName) {
        super(String.format(MESSAGE, inputName));
    }
}
