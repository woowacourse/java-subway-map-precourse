package subway.domain.validator;

import subway.domain.Name;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationValidator {
    private StationValidator() {
    }

    public static void checkNonExistingName(Name name) {
        if (StationRepository.isExistingName(name)) {
            throw new IllegalArgumentException("이미 존재하는 역 이름입니다.");
        }
    }

    public static void checkIsNotOnLine(Station station) {
        if (station.isOnLine()) {
            throw new IllegalArgumentException("노선에 등록된 역은 삭제할 수 없습니다.");
        }
    }
}
