package subway.domain.menu.exception;

import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.constant.ExceptionMessage;

@SuppressWarnings("serial")
public class DuplicatedStationInLineException extends RuntimeException {
    public DuplicatedStationInLineException() {
        super(CommonMessage.NEW_LINE + CommonMessage.ERROR + CommonMessage.SPACE
                + ExceptionMessage.DUPLICATED_STATION_IN_LINE + CommonMessage.NEW_LINE);
    }
}
