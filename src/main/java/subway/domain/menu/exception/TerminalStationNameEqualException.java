package subway.domain.menu.exception;

import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.constant.ExceptionMessage;

@SuppressWarnings("serial")
public class TerminalStationNameEqualException extends RuntimeException {
    public TerminalStationNameEqualException() {
        super(CommonMessage.NEW_LINE + CommonMessage.ERROR + CommonMessage.SPACE
        + ExceptionMessage.TERMINAL_STATION_NAME_EQUAL + CommonMessage.NEW_LINE);
    }
}
