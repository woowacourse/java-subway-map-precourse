package subway.domain.validator;

import subway.domain.Station;
import subway.domain.exception.AlreadyExistingStationException;
import subway.domain.exception.NonExistingStationException;

public class StationValidator {
    private StationValidator() {
    }

    public static void checkNotExistingName(boolean isContain) {
        if (isContain) {
            throw new AlreadyExistingStationException();
        }
    }

    public static void checkIsNotOnLine(Station station) {
        if (station.isOnLine()) {
            throw new NonExistingStationException();
        }
    }
}
