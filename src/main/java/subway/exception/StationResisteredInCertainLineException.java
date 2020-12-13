package subway.exception;

public class StationResisteredInCertainLineException extends IllegalArgumentException {
    private static final String MESSAGE = "노선에 등록된 역은 삭제할 수 없습니다. (input: \"%s\")";

    public StationResisteredInCertainLineException(String inputName) {
        super(String.format(MESSAGE, inputName));
    }
}
