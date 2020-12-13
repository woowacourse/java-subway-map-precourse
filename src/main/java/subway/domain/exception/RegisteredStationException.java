package subway.domain.exception;

public class RegisteredStationException extends RuntimeException {
    private static final String REGISTERED_STATION_ERROR_MESSAGE = "\n[ERROR] 노선에 등록되어 있어 삭제할 수 없는 역입니다.";

    public RegisteredStationException() {
        super(REGISTERED_STATION_ERROR_MESSAGE);
    }
}
