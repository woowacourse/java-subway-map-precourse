package subway.utils;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class Validator implements Message {

    private static final int MIN_NAME_LENGTH = 3;

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

    public static boolean isStationRegisteredInLine(String name) {
        // TODO : 해당 역이 노선에 등록되어 있는지 확인
        return false;
    }

    public static boolean isValidNameLength(String name) {
        return name.length() >= MIN_NAME_LENGTH;
    }

}
