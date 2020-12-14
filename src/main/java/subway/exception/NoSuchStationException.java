package subway.exception;

public class NoSuchStationException extends RuntimeException{
    private static final String ERROR_MESSAGE = "[ERROR] 해당 역은 존재하지 않습니다.";

    public NoSuchStationException() {
        super(ERROR_MESSAGE);
    }
}
