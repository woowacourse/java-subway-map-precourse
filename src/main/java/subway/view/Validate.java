package subway.view;

import java.util.List;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.menu.constant.CategoryType;
import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.constant.ExceptionMessage;
import subway.domain.menu.exception.DuplicatedInputException;
import subway.domain.menu.exception.DuplicatedStationInLineException;
import subway.domain.menu.exception.ExcessSectionOrderInputException;
import subway.domain.menu.exception.NotAccptedDeleteInputException;
import subway.domain.menu.exception.NotAccptedDeleteSectionStationInputException;
import subway.domain.menu.exception.NotAccptedInputException;
import subway.domain.menu.exception.NotAccptedInputLengthException;
import subway.domain.menu.exception.NotAccptedSectionOrderInputException;
import subway.domain.menu.exception.NotAccptedSectionStationInputException;
import subway.domain.menu.exception.NotRegisterSectionException;
import subway.domain.menu.exception.NotRegisterStationException;
import subway.domain.menu.exception.StationInLineMinNumException;
import subway.domain.menu.exception.TerminalStationNameEqualException;

public class Validate {
    private static final int MIN_ORDER = 1;
    private static final int MIN_LENGTH = 2;

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

    public String isAccptedInputTerminalStation(String input) {
        if (isNotAccptedInputLength(input)) {
            throw new NotAccptedInputLengthException();
        }

        // 이 함수의 반환값이 false라면, 삭제할 역이 존재한다는 의미이고,
        // 다시 말해서 역 리스트에 역이 존재한다는 뜻.
        if (isNotAccptedDeleteInput(input, CategoryType.STATION)) {
            throw new NotRegisterStationException();
        }
        return input;
    }

    public String isAccptedInputTerminalStation(String input, String upwardStation) {
        if (isNotAccptedInputLength(input)) {
            throw new NotAccptedInputLengthException();
        }

        if (isNotAccptedDeleteInput(input, CategoryType.STATION)) {
            throw new NotRegisterStationException();
        }

        if (upwardStation.equals(input)) {
            throw new TerminalStationNameEqualException();
        }
        return input;
    }

    public String isAccptedDeleteInput(String input, String category) {
        if (isNotAccptedInputLength(input)) {
            throw new NotAccptedInputLengthException();
        }

        if (isNotAccptedDeleteInput(input, category)) {
            throw new NotAccptedDeleteInputException();
        }

        // 이 함수의 반환값이 false라면, 삭제할 노선이 존재한다는 의미이고,
        // 다시 말해서 노선 리스트에 노선이 존재한다는 뜻.
        if (category.equals(CategoryType.STATION) && isDuplicatedStationInLine(input)) {
            throw new DuplicatedStationInLineException();
        }
        return input;
    }

    public String isAccptedInputSectionLine(String input) {
        if (isNotAccptedInputLength(input)) {
            throw new NotAccptedInputLengthException();
        }

        if (isNotAccptedDeleteInput(input, CategoryType.LINE)) {
            throw new NotRegisterSectionException();
        }
        return input;
    }

    public String isAccptedInputSectionStation(String input, Line line) {
        if (isNotAccptedSectionStation(input, line)) {
            throw new NotAccptedSectionStationInputException();
        }
        return input;
    }

    public String isAccptedInputSectionOrder(String input, Line line) {
        if (isNotAccptedSectionOrder(input)) {
            throw new NotAccptedSectionOrderInputException();
        }

        int n = Integer.parseInt(input);
        if (ExcessSectionOrder(n, line)) {
            throw new ExcessSectionOrderInputException();
        }
        
        return String.valueOf(n - MIN_ORDER);
    }

    public String isAccptedInputSectionDeleteStation(String input, Line line) {
        if (isNotAccptedInputLength(input)) {
            throw new NotAccptedInputLengthException();
        }

        if (isNotAccptedDeleteSectionStation(input, line)) {
            throw new NotAccptedDeleteSectionStationInputException();
        }

        if (isStationInLineMinNum(line)) {
            throw new StationInLineMinNumException();
        }
        return input;
    }

    private boolean isNotAccptedInputLength(String input) {
        if (input.length() < MIN_LENGTH) {
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

    private boolean isNotAccptedDeleteInput(String input, String category) {
        if (category.equals(CategoryType.STATION)) {
            return StationRepository.stations().stream().noneMatch(station -> station.getName().equals(input));
        }

        if (category.equals(CategoryType.LINE)) {
            return LineRepository.lines().stream().noneMatch(line -> line.getName().equals(input));
        }
        return false;
    }

    private boolean isNotAccptedSectionStation(String input, Line line) {
        return line.getStationList().stream().anyMatch(station -> station.getName().equals(input));
    }

    private boolean isNotAccptedSectionOrder(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return true;
            }
        }
        
        int n = Integer.parseInt(input);
        if (n < MIN_ORDER) {
            return true;
        }
        return false;
    }

    private boolean ExcessSectionOrder(int input, Line line) {
        int max_order = line.getStationList().size() + MIN_ORDER;

        if (input > max_order) {
            return true;
        }
        return false;
    }

    private boolean isNotAccptedDeleteSectionStation(String input, Line line) {
        return line.getStationList().stream().noneMatch(station -> station.getName().equals(input));
    }

    private boolean isStationInLineMinNum(Line line) {
        return line.getStationList().size() == MIN_LENGTH;
    }
}
