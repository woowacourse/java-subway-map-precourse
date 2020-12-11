package subway.utils;

import subway.domain.*;

import java.util.List;
import java.util.Objects;

import static subway.utils.ParseUtils.parseStringToInt;

public class InputValidation {
    private static final int NAME_MIN_LENGTH = 2;
    private static final int MIN_COUNT_OF_DELETE_SECTION = 2;

    public void validateMenuRange(List<String> menuRange, String menu) {
        boolean isContains = menuRange.contains(menu);
        if (!isContains) {
            throw new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다.");
        }
    }

    public void validateNameLengthIsMoreThan2(String name) {
        if (name.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름의 길이는 최소 2이상이어야 합니다.");
        }
    }

    public void validateStationNameIsDuplicate(String name) {
        Station findStation = StationRepository.findStation(name).orElse(null);
        if (Objects.equals(findStation, null)) {
            throw new IllegalArgumentException("[ERROR] 이미 등록된 역 이름입니다.");
        }
    }

    public void validateStationNameIsContains(String name) {
        Station findStation = StationRepository.findStation(name).orElse(null);
        if (Objects.equals(findStation, null)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 역입니다.");
        }
    }

    public void validateLineNameIsDuplicate(String name) {
        Line findLine = LineRepository.findLine(name).orElse(null);
        if (Objects.equals(findLine, null)) {
            throw new IllegalArgumentException("[ERROR] 이미 등록된 노선 이름입니다.");
        }
    }

    public void validateLineNameIsContains(String name) {
        Line findLine = LineRepository.findLine(name).orElse(null);
        if (Objects.equals(findLine, null)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 노선입니다.");
        }
    }

    public void validatePositionIsDigit(String position) {
        boolean isDigit = position.chars().allMatch(Character::isDigit);
        if (!isDigit) {
            throw new IllegalArgumentException("[ERROR] 순서는 숫자만 입력 가능합니다.");
        }
    }

    public int validatePositionIsOver(String lineName, String position, LineStationRepository lineStation) {
        int pos = parseStringToInt(position);
        int stationSizeOfLine = lineStation.getStationSizeOfLine(LineRepository.findLine(lineName).get());
        if (pos > stationSizeOfLine) {
            return stationSizeOfLine;
        }
        return pos;
    }

    public void validateStationSizeOfLineIsMoreThan2(String lineName, LineStationRepository lineStation) {
        int stationSizeOfLine = lineStation.getStationSizeOfLine(LineRepository.findLine(lineName).get());
        if (stationSizeOfLine <= MIN_COUNT_OF_DELETE_SECTION) {
            throw new IllegalArgumentException("[ERROR] 노선에 포함된 역이 두개 이하힙니다.");
        }
    }

    public void validateStationIsContainsLineStation(String stationName, LineStationRepository lineStation) {
        Station findStation = StationRepository.findStation(stationName).get();
        if (lineStation.findStationInLine(findStation)) {
            throw new IllegalArgumentException("[ERROR] 노선에 등록된 역은 삭제할 수 없습니다.");
        }
    }
}