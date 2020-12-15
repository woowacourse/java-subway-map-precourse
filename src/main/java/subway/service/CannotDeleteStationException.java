package subway.service;

public class CannotDeleteStationException extends RuntimeException {
    private static final String ERROR_MESSAGE = "노선에 등록된 지하철 역은 삭제할 수 없습니다.";

    public CannotDeleteStationException() {
        super(ERROR_MESSAGE);
    }
}
