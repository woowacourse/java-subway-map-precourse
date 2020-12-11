package subway.station;

import subway.station.domain.Station;
import subway.station.exception.NotKoreanNameException;
import subway.station.exception.TooShortStationNameException;
import subway.util.InputTypeValidator;

public class StationValidator {
    private StationValidator() {
    }

    public static void validateRegistration(String name) {
        validateNameLength(name);
        validateInputType(name);
    }

    private static void validateNameLength(String name) {
        if (!isAvailableLength(name)) {
            throw new TooShortStationNameException();
        }
    }

    private static boolean isAvailableLength(String name) {
        return name.length() >= Station.MIN_NAME_LENGTH;
    }

    private static void validateInputType(String name) {
        if (!InputTypeValidator.isKorean(name)) {
            throw new NotKoreanNameException();
        }
    }
}
