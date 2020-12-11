package subway.utils;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;
import java.util.Objects;

public class InputValidation {
    private static final int NAME_MIN_LENGTH = 2;

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
}