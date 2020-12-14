package subway.domain.validator;

import subway.domain.Station;

public class StationValidator {
    private StationValidator() {
    }

    public static void checkNotExistingName(boolean isContain) {
        if (isContain) {
            throw new IllegalArgumentException("중복된 역 이름 입니다.");
        }
    }

    public static void checkIsNotOnLine(Station station) {
        if (station.isOnLine()) {
            throw new IllegalArgumentException("노선에 등록된 역은 삭제할 수 없습니다.");
        }
    }
}
