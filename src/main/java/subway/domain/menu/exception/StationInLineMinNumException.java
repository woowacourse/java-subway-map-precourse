package subway.domain.menu.exception;

import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.constant.ExceptionMessage;

@SuppressWarnings("serial")
public class StationInLineMinNumException extends RuntimeException {
    public StationInLineMinNumException() {
        super(CommonMessage.NEW_LINE + CommonMessage.ERROR + CommonMessage.SPACE
                + ExceptionMessage.STATION_IN_LINE_MIN_NUM + CommonMessage.NEW_LINE);
    }
}
