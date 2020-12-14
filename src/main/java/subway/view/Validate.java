package subway.view;

import java.util.List;

import subway.domain.StationRepository;
import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.constant.ExceptionMessage;
import subway.domain.menu.exception.DuplicatedInputException;
import subway.domain.menu.exception.NotAccptedInputException;
import subway.domain.menu.exception.NotAccptedInputLengthException;

public class Validate {
    public char isAccptedInput(List<Character> selMenu, char input) {
        if (selMenu.stream().anyMatch(menu -> menu == input)) {
            return input;
        }
        throw new NotAccptedInputException(CommonMessage.NEW_LINE + CommonMessage.ERROR + CommonMessage.SPACE
                + ExceptionMessage.NOT_ACCPTED_INPUT_MESSAGE + CommonMessage.NEW_LINE);
    }

    public String isAccptedRegisterInput(String input) {
        if (isNotAccptedInputLength(input)) {
            throw new NotAccptedInputLengthException(CommonMessage.NEW_LINE + CommonMessage.ERROR + CommonMessage.SPACE
                    + ExceptionMessage.NOT_ACCPTED_INPUT_LENGTH_MESSAGE + CommonMessage.NEW_LINE);
        }

        if (isDuplicatedInput(input)) {
            throw new DuplicatedInputException(CommonMessage.NEW_LINE + CommonMessage.ERROR + CommonMessage.SPACE
                    + ExceptionMessage.DUPLICATED_INPUT_STATION + CommonMessage.NEW_LINE);
        }
        return input;
    }

    private boolean isNotAccptedInputLength(String input) {
        if (input.length() < 2) {
            return true;
        }
        return false;
    }

    private boolean isDuplicatedInput(String input) {
        return StationRepository.stations().stream().anyMatch(station -> station.getName().equals(input));
    }
}
