package subway.exception;

import subway.domain.name.StationName;

public class StationNotFountException extends RuntimeException {

    private static final String ERROR_MESSAGE = "[ERROR] 존재하지 않는 역이름 입니다. INPUT:%s ";

    public StationNotFountException(String name) {
        super(String.format(ERROR_MESSAGE, name));
    }

    public StationNotFountException(StationName stationName) {
        super(String.format(ERROR_MESSAGE, stationName.toString()));
    }
}
