package subway.domain.entity;

public class LastStationDuplicationException extends RuntimeException {
    private static final String ERROR_MESSAGE = "상행 종점역과 하행 종점역은 중복될 수 없습니다.";

    public LastStationDuplicationException() {
        super(ERROR_MESSAGE);
    }
}
