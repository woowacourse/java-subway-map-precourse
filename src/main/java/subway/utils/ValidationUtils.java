package subway.utils;

import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.ResisteredStations;
import subway.domain.StationRepository;
import subway.exception.BlankNameException;
import subway.exception.CannotDeleteStationMoreException;
import subway.exception.DuplicatedLineException;
import subway.exception.DuplicatedStationInLineException;
import subway.exception.NotPositiveIntegerException;
import subway.exception.DuplicatedStationException;
import subway.exception.IllegalFunctionException;
import subway.exception.NullLineException;
import subway.exception.NullStationException;
import subway.exception.NullStationInLineException;
import subway.exception.StationResisteredInCertainLineException;
import subway.exception.SectionOutOfRangeException;
import subway.exception.TooShortNameException;

public class ValidationUtils {
    public static void validateTooShortName(String name, int minimumLength) {
        if (name.length() < minimumLength) {
            throw new TooShortNameException(name, minimumLength);
        }
    }

    public static void validateBlankName(String name) {
        if (RegexUtils.isBlank(name)) {
            throw new BlankNameException();
        }
    }

    public static void validateNullStation(String stationName) {
        if (!StationRepository.containsStation(stationName)) {
            throw new NullStationException(stationName);
        }
    }

    public static void validateDuplicatedStation(String stationName) {
        if (StationRepository.containsStation(stationName)) {
            throw new DuplicatedStationException(stationName);
        }
    }

    public static void validateNullLine(String line) {
        if (!LineRepository.containsLine(line)) {
            throw new NullLineException(line);
        }
    }

    public static void validateDuplicatedLine(Line line) {
        if (LineRepository.containsLine(line)) {
            throw new DuplicatedLineException(line.getName());
        }
    }

    public static void validateNullStationInLine(ResisteredStations stations, String stationName) {
        if (!stations.contains(stationName)) {
            throw new NullStationInLineException(stationName);
        }
    }

    public static void validateDuplicatedStationInLine(ResisteredStations stations, String stationName) {
        if (stations.contains(stationName)) {
            throw new DuplicatedStationInLineException(stationName);
        }
    }

    public static void validateCannotDeleteStationMore(ResisteredStations stations, int minimumStationCount) {
        if (stations.size() <= minimumStationCount) {
            throw new CannotDeleteStationMoreException(minimumStationCount);
        }
    }

    public static void validateStationResisteredInCertainLine(String stationName) {
        if (LineRepository.anyLineContainsThisStation(stationName)) {
            throw new StationResisteredInCertainLineException(stationName);
        }
    }

    public static void validateSectionOutOfRange(int inputOrder, int firstOrder, int lastOrder) {
        if (inputOrder <= firstOrder || inputOrder > lastOrder) {
            throw new SectionOutOfRangeException(inputOrder);
        }
    }

    public static void validateIllegalFunction(String inputKey, List<String> keys) {
        if (!keys.contains(inputKey)) {
            throw new IllegalFunctionException(inputKey);
        }
    }

    public static void validateNotPositiveInteger(String input) {
        if (!RegexUtils.isPositiveInteger(input)) {
            throw new NotPositiveIntegerException(input);
        }
    }
}
