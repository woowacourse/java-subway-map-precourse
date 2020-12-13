package subway.domain.validator;

import subway.domain.LineRepository;
import subway.domain.Name;
import subway.domain.Station;

public class LineValidator {
    private LineValidator() {
    }

    public static void checkNonExistingName(Name name) {
        if (LineRepository.isExistingName(name)) {
            throw new IllegalArgumentException("이미 존재하는 역 이름입니다.");
        }
    }

    public static void checkEndStationsDifferent(Station firstStation, Station lastStation) {
        if (firstStation.equals(lastStation)) {
            throw new IllegalArgumentException("상행 종점역과 하행 종점역은 같을 수 없습니다.");
        }
    }
}
