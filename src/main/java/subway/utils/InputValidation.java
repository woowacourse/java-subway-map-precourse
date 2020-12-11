package subway.utils;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;

public class InputValidation {
    private static final int NAME_MIN_LENGTH = 2;

    public void validateMenuRange(List<String> menuRange, String menu) {
        boolean isContains = menuRange.contains(menu);
        if(!isContains) {
            throw new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다.");
        }
    }

    public void validateNameLengthIsMoreThan2(String name) {
        if(name.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름의 길이는 최소 2이상이어야 합니다.");
        }
    }

    public void validateStationNameIsDuplicate(String name) {
        Station findStation = StationRepository.findStation(name).orElse(null);
        if(findStation.equals(null)) {
            throw new IllegalArgumentException("[ERROR] 이미 등록된 역 이름입니다.");
        }
    }
}