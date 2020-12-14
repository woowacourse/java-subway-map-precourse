package subway.exception;

import subway.domain.station.Station;

public class AlreadyAddStationException extends RuntimeException {
    private static final String ERROR_MESSAGE = "[ERROR] 이미 존재하는 역입니다. INPUT:%s";

    public AlreadyAddStationException(Station station) {
        super(String.format(ERROR_MESSAGE, station.toString()));
    }
}
