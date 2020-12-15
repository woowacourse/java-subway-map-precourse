package subway.exception;

public class SelectNotValidException extends SubwayException {

    private final static String SELECT_NOT_VALID_ERROR = ERROR + " 선택할 수 없는 기능입니다.";

    public SelectNotValidException() {
    }

    @Override
    public String getMessage() {
        return SELECT_NOT_VALID_ERROR;
    }
}
