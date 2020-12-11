package subway.station;

import subway.station.domain.Station;
import subway.station.exception.TooShortStationNameException;

public class StationValidator {
    private StationValidator() {
    }

    public static void validateRegistration(String name) {
        validateNameLength(name);
    }

    private static void validateNameLength(String name) {
        if (!isAvailableLength(name)) {
            throw new TooShortStationNameException();
        }
    }

    private static boolean isAvailableLength(String name) {
        return name.length() >= Station.MIN_NAME_LENGTH;
    }
}
