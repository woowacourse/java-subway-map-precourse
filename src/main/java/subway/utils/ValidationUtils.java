package subway.utils;

import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.exception.BlankNameException;
import subway.exception.DuplicatedLineNameException;
import subway.exception.DuplicatedStationInLineException;
import subway.exception.NotPositiveIntegerException;
import subway.exception.DuplicatedStationNameException;
import subway.exception.IllegalFunctionException;
import subway.exception.NullLineException;
import subway.exception.NullStationException;
import subway.exception.NullStationInLineException;
import subway.exception.ResisteredStationException;
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
            throw new DuplicatedStationNameException(stationName);
        }
    }

    public static void validateNullLine(String line) {
        if (!LineRepository.containsLine(line)) {
            throw new NullLineException(line);
        }
    }

    public static void validateDuplicatedLine(Line line) {
        if (LineRepository.containsLine(line)) {
            throw new DuplicatedLineNameException(line.getName());
        }
    }

    public static void validateNullStationInLine(Line line, String stationName) {
        if (!line.containsStation(stationName)) {
            throw new NullStationInLineException(stationName);
        }
    }

    public static void validateDuplicatedStationInLine(Line line, String stationName) {
        if (line.containsStation(stationName)) {
            throw new DuplicatedStationInLineException(stationName);
        }
    }

    public static void validateResisteredStation(String stationName) {
        if (LineRepository.anyLineContainsStation(stationName)) {
            throw new ResisteredStationException(stationName);
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
