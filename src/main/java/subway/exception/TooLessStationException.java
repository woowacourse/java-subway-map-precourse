package subway.exception;

import subway.domain.StationRepository;

public class TooLessStationException extends FunctionException {

    public static final String TOO_LESS_STATIONS_ERROR =
            String.format("역이 %d개 이하인 노선의 역은 제거할 수 업습니다", StationRepository.MINIMUM_STATION_SIZE);

    public TooLessStationException() {
        super(TOO_LESS_STATIONS_ERROR);
    }
}
