package subway.utils;

import java.util.ArrayList;
import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Validator implements Message {

    private static final int MIN_NAME_LENGTH = 3;
    private static final int ADJUST = 1;
    private static final int MIN_SIZE_STATIONS_IN_LINE = 2;
    private static final int MIN_INDEX = 1;

    public static void checkValidStationName(String name) {
        if (!isValidNameLength(name)) {
            throw new IllegalArgumentException(ERROR_INVALID_STATION_NAME_LENGTH);
        }
        if (StationRepository.hasStation(name)) {
            throw new IllegalArgumentException(ERROR_ALREADY_REGISTERED_STATION);
        }
    }

    public static void checkDeletableStation(String name) {
        if (isStationRegisteredInLine(name)) {
            throw new IllegalArgumentException(ERROR_STATION_REGISTERED_IN_LINE);
        }
        if (!StationRepository.hasStation(name)) {
            throw new IllegalArgumentException(ERROR_NOT_REGISTERED_STATION);
        }
    }

    public static void checkValidLineName(String name) {
        if (!isValidNameLength(name)) {
            throw new IllegalArgumentException(ERROR_INVALID_LINE_NAME_LENGTH);
        }
        if (LineRepository.hasLine(name)) {
            throw new IllegalArgumentException(ERROR_ALREADY_REGISTERED_LINE);
        }
    }

    public static void checkRegisteredLine(String name) {
        if (!LineRepository.hasLine(name)) {
            throw new IllegalArgumentException(ERROR_NOT_REGISTERED_LINE);
        }
    }

    public static boolean isStationRegisteredInLine(String name) {
        ArrayList<Line> lines = LineRepository.getAllLines();
        return lines.stream()
            .anyMatch(line -> line.hasStation(name));
    }

    public static boolean isValidNameLength(String name) {
        return name.length() >= MIN_NAME_LENGTH;
    }

    public static void checkMinIndex(int index) {
        if (index < MIN_INDEX) {
            throw new IllegalArgumentException(ERROR_OUT_OF_MIN_INDEX);
        }
    }

    public static void checkDuplicateStation(List<Station> stations, Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException(ERROR_ALREADY_REGISTERED_STATION);
        }
    }

    public static void checkValidRange(List<Station> stations, int index) {
        if (index > stations.size() - ADJUST) {
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE);
        }
    }

    public static void checkMinSizeStationsInLine(List<Station> stations) {
        if (stations.size() <= MIN_SIZE_STATIONS_IN_LINE) {
            throw new IllegalArgumentException(ERROR_MIN_SIZE_STATIONS_IN_LINE);
        }
    }
}
