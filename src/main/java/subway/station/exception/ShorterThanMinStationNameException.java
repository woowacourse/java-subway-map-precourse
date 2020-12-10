package subway.station.exception;

import subway.station.domain.Station;

public class ShorterThanMinStationNameException extends IllegalArgumentException {

    private static final String MESSAGE = "지하철 역 이름은 " + Station.MIN_NAME_SIZE
            + "글자 이상이어야 합니다. (입력 값: '%s')";

    public ShorterThanMinStationNameException(final String input) {
        super(String.format(MESSAGE, input));
    }
}
