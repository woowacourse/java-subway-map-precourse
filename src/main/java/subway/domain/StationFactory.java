package subway.domain;

import static subway.util.TextConstant.*;

public class StationFactory {
    public static Station makeStation(String name) {
        if (name.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(ERR_SHORT_NAME_MSG);
        }
        if (!name.endsWith(STATION)) {
            throw new IllegalArgumentException(ERR_WRONG_STATION_NAME_SUFFIX);
        }
        return new Station(name);
    }
}
