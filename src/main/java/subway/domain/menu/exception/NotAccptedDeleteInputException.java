package subway.domain.menu.exception;

import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.constant.ExceptionMessage;

@SuppressWarnings("serial")
public class NotAccptedDeleteInputException extends RuntimeException {
    public NotAccptedDeleteInputException() {
        super(CommonMessage.NEW_LINE + CommonMessage.ERROR + CommonMessage.SPACE
        + ExceptionMessage.NOT_ACCPTED_DELETE_INPUT_MESSAGE + CommonMessage.NEW_LINE);
    }
}
