package subway.domain.menu.exception;

import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.constant.ExceptionMessage;

@SuppressWarnings("serial")
public class NotAccptedSectionStationInputException extends RuntimeException {
    public NotAccptedSectionStationInputException() {
        super(CommonMessage.NEW_LINE + CommonMessage.ERROR + CommonMessage.SPACE
        + ExceptionMessage.NOT_ACCPTED_SECTION_STATION_INPUT + CommonMessage.NEW_LINE);
    }
}
