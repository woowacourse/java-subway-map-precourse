package subway.domain.menu.exception;

import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.constant.ExceptionMessage;

@SuppressWarnings("serial")
public class NotAccptedInputException extends RuntimeException {
    public NotAccptedInputException() {
        super(CommonMessage.NEW_LINE + CommonMessage.ERROR + CommonMessage.SPACE
        + ExceptionMessage.NOT_ACCPTED_INPUT_MESSAGE + CommonMessage.NEW_LINE);
    }
}
