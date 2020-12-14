package subway.exception;

public class AlreadyExistStationException extends RuntimeException{
    private static final String ERROR_MESSAGE = "[ERROR] 이미 등록된 역입니다.";

    public AlreadyExistStationException() {
        super(ERROR_MESSAGE);
    }
}
