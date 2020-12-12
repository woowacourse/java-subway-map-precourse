package subway.exception;

import subway.domain.Line.Line;
import subway.domain.station.Station;

public class CannotRemoveException extends RuntimeException {

    private static final String ERROR_MESSAGE_STATION = "[ERROR] 입력하신 역은 삭제할 수 없습니다.";
    private static final String ERROR_MESSAGE_LINE = "[ERROR] 노선에는 최소 2개 이상의 역이 등록되어 있어야합니다.";
    public CannotRemoveException(Station station) {
        super(ERROR_MESSAGE_STATION);
    }

    public CannotRemoveException(Line line) {
        super(ERROR_MESSAGE_LINE);
    }
}
