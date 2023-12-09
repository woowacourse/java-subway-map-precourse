package subway.util;

import static subway.exception.ExceptionMessage.INVALID_ADD_LINE_ALREADY_EXISTS;
import static subway.exception.ExceptionMessage.INVALID_ADD_LINE_NAME;
import static subway.exception.ExceptionMessage.INVALID_ADD_LINE_NAME_CHARACTER;
import static subway.exception.ExceptionMessage.INVALID_ADD_LINE_NAME_SUFFIX;
import static subway.exception.ExceptionMessage.INVALID_REMOVE_STATION_IN_LINE;
import static subway.exception.ExceptionMessage.NOT_FOUND_LINE;
import static subway.exception.ExceptionMessage.NOT_FOUND_STATION;
import static subway.exception.ExceptionMessage.STATION_ALREADY_EXISTS;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayValidator {
    private static final int MIN_LINE_NAME_LENGTH = 2;
    private static final char MIN_NUMBER_LINE_NAME_CHARACTER = '0';
    private static final char MAX_NUMBER_LINE_NAME_CHARACTER = '9';
    private static final char MIN_KOREAN_LINE_NAME = '가';
    private static final char MAX_KOREAN_LINE_NAME = '힣';
    private static final String LINE_NAME_SUFFIX = "선";


    public static void validateSectionExist(Line line, Station station) {
        if (!SectionRepository.contains(line, station)) {
            throw new IllegalArgumentException(NOT_FOUND_STATION.getMessage());
        }
    }

    public static void validateExistLine(String lineName) {
        if (LineRepository.containsLineName(lineName)) {
            throw new IllegalArgumentException(INVALID_ADD_LINE_ALREADY_EXISTS.getMessage());
        }
    }

    public static void validateLineNameLength(String lineName) {
        if (lineName.length() < MIN_LINE_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_ADD_LINE_NAME.getMessage());
        }
    }

    public static void validateLineNameCharacter(String lineName) {
        if (lineName.chars()
                .anyMatch(character ->
                        (character < MIN_NUMBER_LINE_NAME_CHARACTER || MAX_NUMBER_LINE_NAME_CHARACTER < character) && (
                                character < MIN_KOREAN_LINE_NAME
                                        || MAX_KOREAN_LINE_NAME < character))) {
            throw new IllegalArgumentException(INVALID_ADD_LINE_NAME_CHARACTER.getMessage());
        }
    }

    public static void validateLineNameSuffix(String lineName) {
        if (!lineName.endsWith(LINE_NAME_SUFFIX)) {
            throw new IllegalArgumentException(INVALID_ADD_LINE_NAME_SUFFIX.getMessage());
        }
    }

    public static void validateStationExist(Station station) {
        if (StationRepository.contains(station)) {
            throw new IllegalArgumentException(STATION_ALREADY_EXISTS.getMessage());
        }
    }

    public static void validateLineExist(String lineName) {
        if (!LineRepository.containsLineName(lineName)) {
            throw new IllegalArgumentException(NOT_FOUND_LINE.getMessage());
        }
    }

    public static void validateStationContainedAnyLine(Station station) {
        if (SectionRepository.containsAnyLine(station)) {
            throw new IllegalArgumentException(INVALID_REMOVE_STATION_IN_LINE.getMessage());
        }
    }
}
