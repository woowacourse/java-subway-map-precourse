package subway.view;

import java.util.List;

import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.constant.ExceptionMessage;
import subway.domain.menu.exception.NotAccptedInputException;

public class Validate {
    public char isAccptedInput(List<Character> selMenu, char input) {
        if (selMenu.stream().anyMatch(menu -> menu == input)) {
            return input;
        }
        throw new NotAccptedInputException(CommonMessage.NEW_LINE + CommonMessage.ERROR + CommonMessage.SPACE + ExceptionMessage.NOT_ACCPTED_INPUT_MESSAGE + CommonMessage.NEW_LINE);
    }
}
