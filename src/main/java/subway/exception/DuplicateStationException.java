package subway.exception;

public class DuplicateStationException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "[ERROR] 동일한 역을 연결할 수 없습니다.";

    public DuplicateStationException() {
        super(ERROR_MESSAGE);
    }
}
