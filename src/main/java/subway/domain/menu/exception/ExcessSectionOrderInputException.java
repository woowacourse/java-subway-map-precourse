package subway.domain.menu.exception;

import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.constant.ExceptionMessage;

@SuppressWarnings("serial")
public class ExcessSectionOrderInputException extends RuntimeException {
    public ExcessSectionOrderInputException() {
        super(CommonMessage.NEW_LINE + CommonMessage.ERROR + CommonMessage.SPACE
                + ExceptionMessage.EXCESS_SECTION_ORDER_INPUT + CommonMessage.NEW_LINE);
    }
}
