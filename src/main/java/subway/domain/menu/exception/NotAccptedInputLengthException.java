package subway.domain.menu.exception;

import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.constant.ExceptionMessage;

@SuppressWarnings("serial")
public class NotAccptedInputLengthException extends RuntimeException {
    public NotAccptedInputLengthException() {
        super(CommonMessage.NEW_LINE + CommonMessage.ERROR + CommonMessage.SPACE
                + ExceptionMessage.NOT_ACCPTED_INPUT_LENGTH_MESSAGE + CommonMessage.NEW_LINE);
    }
}
