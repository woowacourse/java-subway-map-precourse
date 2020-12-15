package subway.domain.menu.exception;

import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.constant.ExceptionMessage;

@SuppressWarnings("serial")
public class NotAccptedDeleteSectionStationInputException extends RuntimeException {
    public NotAccptedDeleteSectionStationInputException() {
        super(CommonMessage.NEW_LINE + CommonMessage.ERROR + CommonMessage.SPACE
                + ExceptionMessage.NOT_ACCPTED_DELETE_SECTION_STATION_INPUT + CommonMessage.NEW_LINE);
    }
}
