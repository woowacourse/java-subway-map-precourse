package subway.utils;

import subway.domain.*;

import java.util.List;
import java.util.Objects;

import static subway.utils.ParseUtils.parseStringToInt;

public class InputValidation {
    private static final int NAME_MIN_LENGTH = 2;
    private static final int MIN_COUNT_OF_DELETE_SECTION = 2;
    private static final int SECTION_POINT_ONE = 1;
    private static final int SECTION_POINT_ZERO = 0;

    public boolean validateMenuRange(List<String> menuRange, String menu) {
        boolean isContains = menuRange.contains(menu);
        if (!isContains) {
            System.out.println("\n[ERROR] 선택할 수 없는 기능입니다.");
            return false;
        }
        return true;
    }

    public boolean validateNameLengthIsMoreThan2(String name) {
        if (name.length() < NAME_MIN_LENGTH) {
            System.out.println("\n[ERROR] 이름의 길이는 최소 2이상이어야 합니다.");
            return false;
        }
        return true;
    }

    public boolean validateStationNameIsDuplicate(String name) {
        Station findStation = StationRepository.findStation(name);
        if (!Objects.equals(findStation, null)) {
            System.out.println("\n[ERROR] 이미 등록된 역 이름입니다.");
            return false;
        }
        return true;
    }

    public boolean validateStationNameIsContains(String name) {
        Station findStation = StationRepository.findStation(name);
        if (Objects.equals(findStation, null)) {
            System.out.println("\n[ERROR] 존재하지 않는 역입니다.");
            return false;
        }
        return true;
    }

    public boolean validateLineNameIsDuplicate(String name) {
        Line findLine = LineRepository.findLine(name);
        if (!Objects.equals(findLine, null)) {
            System.out.println("\n[ERROR] 이미 등록된 노선 이름입니다.");
            return false;
        }
        return true;
    }

    public boolean validateLineNameIsContains(String name) {
        Line findLine = LineRepository.findLine(name);
        if (Objects.equals(findLine, null)) {
            System.out.println("\n[ERROR] 존재하지 않는 노선입니다.");
            return false;
        }
        return true;
    }

    public boolean validatePositionIsDigit(String position) {
        boolean isDigit = position.chars().allMatch(Character::isDigit);
        if (!isDigit) {
            System.out.println("\n[ERROR] 순서는 숫자만 입력 가능합니다.");
            return false;
        }
        return true;
    }

    public int validatePositionIsOutOfRange(String lineName, String position, LineStationRepository lineStation) {
        int pos = parseStringToInt(position) - SECTION_POINT_ONE;
        int stationSizeOfLine = lineStation.getStationSizeOfLine(LineRepository.findLine(lineName));
        if (pos > stationSizeOfLine) {
            return stationSizeOfLine;
        }
        if (pos < SECTION_POINT_ZERO) {
            return SECTION_POINT_ZERO;
        }
        return pos;
    }

    public boolean validateStationSizeOfLineIsMoreThan2(String lineName, LineStationRepository lineStation) {
        int stationSizeOfLine = lineStation.getStationSizeOfLine(LineRepository.findLine(lineName));
        if (stationSizeOfLine <= MIN_COUNT_OF_DELETE_SECTION) {
            System.out.println("\n[ERROR] 노선에 포함된 역이 두개 이하입니다.");
            return false;
        }
        return true;
    }

    public boolean validateStationIsContainsLineStation(String stationName, LineStationRepository lineStation) {
        Station findStation = StationRepository.findStation(stationName);
        if (lineStation.findStationInLine(findStation)) {
            System.out.println("\n[ERROR] 노선에 등록된 역은 삭제할 수 없습니다.");
            return false;
        }
        return true;
    }

    public String isFail() {
        return "[ERROR] INPUT FAIL";
    }
}