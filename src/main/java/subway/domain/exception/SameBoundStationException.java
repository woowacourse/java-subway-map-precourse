package subway.domain.exception;

public class SameBoundStationException extends RuntimeException {
    private static final String SAME_BOUND_ERROR_MESSAGE = "\n[ERROR] 상행 종점역과 하행 종점역은 서로 다른 역이어야 합니다.";

    public SameBoundStationException() {
        super(SAME_BOUND_ERROR_MESSAGE);
    }
}
