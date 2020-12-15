package subway.view;

import java.util.List;

import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.menu.constant.CategoryType;
import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.constant.ExceptionMessage;
import subway.domain.menu.exception.DuplicatedInputException;
import subway.domain.menu.exception.DuplicatedStationInLineException;
import subway.domain.menu.exception.NotAccptedDeleteInputException;
import subway.domain.menu.exception.NotAccptedInputException;
import subway.domain.menu.exception.NotAccptedInputLengthException;

public class Validate {
    public char isAccptedInput(List<Character> selMenu, char input) {
        if (selMenu.stream().anyMatch(menu -> menu == input)) {
            return input;
        }
        throw new NotAccptedInputException();
    }

    public String isAccptedRegisterInput(String input, String category) {
        if (isNotAccptedInputLength(input)) {
            throw new NotAccptedInputLengthException();
        }

        if (category.equals(CategoryType.STATION) && isDuplicatedInput(input, category)) {
            throw new DuplicatedInputException();
        }

        if (category.equals(CategoryType.LINE) && isDuplicatedInput(input, category)) {
            throw new DuplicatedInputException(CommonMessage.NEW_LINE + CommonMessage.ERROR + CommonMessage.SPACE
                    + ExceptionMessage.DUPLICATED_INPUT_LINE + CommonMessage.NEW_LINE);
        }
        return input;
    }

    public String isAccptedDeleteInput(String input) {
        if (isNotAccptedInputLength(input)) {
            throw new NotAccptedInputLengthException();
        }

        if (isDuplicatedStationInLine(input)) {
            throw new DuplicatedStationInLineException();
        }

        if (isNotAccptedDeleteInput(input)) {
            throw new NotAccptedDeleteInputException();
        }
        return input;
    }

    private boolean isNotAccptedInputLength(String input) {
        if (input.length() < 2) {
            return true;
        }
        return false;
    }

    private boolean isDuplicatedInput(String input, String category) {
        if (category.equals(CategoryType.STATION)) {
            return StationRepository.stations().stream().anyMatch(station -> station.getName().equals(input));
        }

        if (category.equals(CategoryType.LINE)) {
            return LineRepository.lines().stream().anyMatch(line -> line.getName().equals(input));
        }
        return false;
    }

    private boolean isDuplicatedStationInLine(String input) {
        for (int i = 0; i < LineRepository.lines().size(); i++) {
            List<Station> stationList = LineRepository.lines().get(i).getStationList();

            if (stationList.stream().anyMatch(station -> station.getName().equals(input))) {
                return true;
            }
        }
        return false;
    }

    private boolean isNotAccptedDeleteInput(String input) {
        return StationRepository.stations().stream().noneMatch(station -> station.getName().equals(input));
    }
}
