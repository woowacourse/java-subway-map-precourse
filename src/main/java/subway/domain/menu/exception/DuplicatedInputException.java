package subway.domain.menu.exception;

import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.constant.ExceptionMessage;

@SuppressWarnings("serial")
public class DuplicatedInputException extends RuntimeException {
    public DuplicatedInputException() {
        super(CommonMessage.NEW_LINE + CommonMessage.ERROR + CommonMessage.SPACE
                + ExceptionMessage.DUPLICATED_INPUT_STATION + CommonMessage.NEW_LINE);
    }

    public DuplicatedInputException(String message) {
        super(message);
    }
}
