package subway.line.exception;

import subway.line.domain.Line;

public class ShorterThanMinLineStationsSizeException extends IllegalArgumentException {

    private static final String MESSAGE = "지하철 노선에 포함된 역이 " + Line.MIN_STATIONS_SIZE +
        "개 이하일 때는 역을 제거할 수 없습니다. (입력 값: '%s')";

    public ShorterThanMinLineStationsSizeException(final String input) {
        super(String.format(MESSAGE, input));
    }
}
