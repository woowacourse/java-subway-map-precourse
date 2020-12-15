package subway.domain.menu.exception;

import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.constant.ExceptionMessage;

@SuppressWarnings("serial")
public class NotRegisterStationException extends RuntimeException {
    public NotRegisterStationException() {
        super(CommonMessage.NEW_LINE + CommonMessage.ERROR + CommonMessage.SPACE
                + ExceptionMessage.NOT_REGISTERED_STATION + CommonMessage.NEW_LINE);
    }
}
