package subway.domain.station;

import subway.exception.ErrorCode;
import subway.exception.StationException;

public class Station implements Comparable<Station> {
    private static final int MIN_SIZE = 2;
    private static final String MUST_CONTAIN_LAST = "역";
    private static final String PERMIT_CHARACTER = "^[가-힣|0-9]*$";

    private String name;

    private Station(String name) {
        this.name = name;
        validateName(name);
    }

    public static Station of(String name) {
        return new Station(name);
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    private void validateName(String name) {
        if (name.length() < MIN_SIZE) {
            throw new StationException(ErrorCode.STATION_NAME_LENGTH_ERROR);
        }
        if (!name.endsWith(MUST_CONTAIN_LAST)) {
            throw new StationException(ErrorCode.STATION_INVALID_LAST_NAME);
        }
        if (!name.matches(PERMIT_CHARACTER)) {
            throw new StationException(ErrorCode.STATION_INVALID_CHARACTER);
        }
    }

    @Override
    public int compareTo(Station o) {
        if (this.name.compareTo(o.name) > 0) {
            return 1;
        }
        return -1;
    }
}
