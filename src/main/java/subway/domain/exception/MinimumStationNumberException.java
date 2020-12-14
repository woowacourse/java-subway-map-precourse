package subway.domain.exception;

public class MinimumStationNumberException extends RuntimeException {
    private static final String MINIMUM_STATION_NUMBER_ERROR_MESSAGE = "\n[ERROR] 노선에 포함된 역이 두 개 이하일 경우 노선에서 역을 제거할 수 없습니다.";

    public MinimumStationNumberException() {
        super(MINIMUM_STATION_NUMBER_ERROR_MESSAGE);
    }
}
