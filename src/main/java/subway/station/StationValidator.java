package subway.station;

import subway.common.util.InputTypeValidator;
import subway.station.domain.Station;
import subway.station.domain.StationRepository;
import subway.station.exception.AlreadyExistStationException;
import subway.station.exception.NotKoreanNameException;
import subway.station.exception.TooShortStationNameException;

public class StationValidator {
    private StationValidator() {
    }

    public static void validateRegistration(String name) {
        validateDuplication(name);
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

    private static void validateDuplication(String name) {
        if (StationRepository.isExist(name)) {
            throw new AlreadyExistStationException();
        }
    }
}
