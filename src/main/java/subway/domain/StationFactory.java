package subway.domain;

import subway.exception.SubwayException;

import static subway.util.TextConstant.*;

public class StationFactory {
    public static Station makeStation(String name) {
        if (name.length() < NAME_MIN_LENGTH) {
            throw new SubwayException(ERR_STATION_SHORT_NAME_MSG);
        }
        if (!name.endsWith(STATION)) {
            throw new SubwayException(ERR_WRONG_STATION_NAME_SUFFIX);
        }
        return new Station(name);
    }
}
