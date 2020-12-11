package subway.station;

import subway.station.domain.Station;
import subway.station.domain.StationRepository;
import subway.station.exception.AlreadyExistException;
import subway.station.exception.NotExistException;
import subway.station.exception.NotKoreanNameException;
import subway.station.exception.TooShortStationNameException;
import subway.util.InputTypeValidator;

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
            throw new AlreadyExistException();
        }
    }

    public static void validateRemoval(String name) {
        validateExistence(name);
    }

    private static void validateExistence(String name) {
        if (!StationRepository.isExist(name)) {
            throw new NotExistException();
        }
    }
}
