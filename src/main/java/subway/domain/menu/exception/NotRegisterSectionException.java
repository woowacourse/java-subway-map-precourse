package subway.domain.menu.exception;

import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.constant.ExceptionMessage;

@SuppressWarnings("serial")
public class NotRegisterSectionException extends RuntimeException {
    public NotRegisterSectionException() {
        super(CommonMessage.NEW_LINE + CommonMessage.ERROR + CommonMessage.SPACE + ExceptionMessage.NOT_REGISTERED_LINE
                + CommonMessage.NEW_LINE);
    }
}
