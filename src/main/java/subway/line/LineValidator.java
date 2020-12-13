package subway.line;

import subway.common.util.InputTypeValidator;
import subway.line.domain.Line;
import subway.line.domain.LineRepository;
import subway.line.exception.AlreadyExistLineException;
import subway.line.exception.IllegalTypeOfNameException;
import subway.line.exception.SameFinalStationException;
import subway.line.exception.TooShortLineNameException;
import subway.station.domain.Station;

public class LineValidator {
    private LineValidator() {
    }

    public static void validateRegistration(String name) {
        validateNameLength(name);
        validateInputType(name);
        validateDuplication(name);
    }

    private static void validateNameLength(String name) {
        if (!isAvailableName(name)) {
            throw new TooShortLineNameException();
        }
    }

    private static boolean isAvailableName(String name) {
        return name.length() >= Line.MIN_NAME_LENGTH;
    }

    private static void validateInputType(String name) {
        if (!InputTypeValidator.isKoreanOrNumeric(name)) {
            throw new IllegalTypeOfNameException();
        }
    }

    private static void validateDuplication(String name) {
        if (LineRepository.isExist(name)) {
            throw new AlreadyExistLineException();
        }
    }

    public static void validateFinalStation(Station topStation, Station bottomStation) {
        if (topStation.equals(bottomStation)) {
            throw new SameFinalStationException();
        }
    }
}
