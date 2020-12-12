package subway.exception;

public class StationAlreadyExistsException extends RuntimeException {

    private static final String MESSAGE = "이미 존재하는 역입니다. 다시 입력해주세요. 입력값: (%s)";

    public StationAlreadyExistsException(String name) {
        super(String.format(MESSAGE, name));
    }
}
