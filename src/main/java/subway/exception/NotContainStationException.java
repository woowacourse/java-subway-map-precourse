package subway.exception;

public class NotContainStationException extends RuntimeException{
    private static final String ERROR_MESSAGE = "[ERROR] 노선에 포함되어 있지 않은 역입니다.";

    public NotContainStationException () {
        super(ERROR_MESSAGE);
    }
}
