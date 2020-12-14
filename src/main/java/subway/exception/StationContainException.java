package subway.exception;

public class StationContainException extends RuntimeException{
    private static final String ERROR_MESSAGE = "[ERROR] 노선에 포함된 역은 제거할 수 없습니다.";

    public StationContainException () {
        super(ERROR_MESSAGE);
    }
}
