package subway.domain.station;

import subway.domain.Line.Line;

public class AlreadyLinkedException extends RuntimeException {

    private static final String ERROR_MESSAGE = "[ERROR] %s과 %s은 이미 연결되어 있습니다.";

    public AlreadyLinkedException(Line line, Station station) {
        super(String.format(ERROR_MESSAGE, line.toString(), station.toString()));
    }
}
