package subway.exception;

import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.StationRepository;

public class SectionExceptionManager extends ExceptionManager {
    public static Error checkValidLineOfSectionRegister(String name) {
        if (!isValidLineName(name)) {
            return Error.INVALID_LINE_NAME_LENGTH;
        }
        if (!LineRepository.hasLine(name)) {
            return Error.NON_EXISTENT_LINE_NAME;
        }
        return Error.OK;
    }

    public static Error checkValidStationOfSectionRegister(String stationName, String lineName) {
        if (!isValidStationName(stationName)) {
            return Error.INVALID_STATION_NAME_LENGTH;
        }
        if (!StationRepository.hasStation(stationName)) {
            return Error.NON_EXISTENT_STATION_NAME;
        }
        if (SectionRepository.isStationInLine(stationName, lineName)) {
            return Error.EXISTENT_STATION_IN_LINE;
        }
        return Error.OK;
    }

    public static Error checkValidIndexOfSectionRegister(String input, String lineName) {
        if (!isNumber(input)) {
            return Error.INVALID_NUMBER_TYPE;
        }
        if (!isValidRange(input, lineName)) {
            return Error.INVALID_STATION_INDEX;
        }
        return Error.OK;
    }

    public static Error checkValidLineOfSectionRemoval(String lineName) {
        if (!isValidLineName(lineName)) {
            return Error.INVALID_LINE_NAME_LENGTH;
        }
        if (!LineRepository.hasLine(lineName)) {
            return Error.NON_EXISTENT_LINE_NAME;
        }
        if (!SectionRepository.isRemovableNumberOfStationInLine(lineName)) {
            return Error.INVALID_NUMBER_OF_STATION_IN_LINE;
        }
        return Error.OK;
    }

    public static Error checkValidStationOfSectionRemoval(String stationName, String lineName) {
        if (!isValidStationName(stationName)) {
            return Error.INVALID_STATION_NAME_LENGTH;
        }
        if (!StationRepository.hasStation(stationName)) {
            return Error.NON_EXISTENT_STATION_NAME;
        }
        if (!SectionRepository.isStationInLine(stationName, lineName)) {
            return Error.NON_EXISTENT_STATION_IN_LINE;
        }
        return Error.OK;
    }

    private static boolean isValidRange(String input, String lineName) {
        int index = -1;
        try {
            index = Integer.parseInt(input) - 1;
        } catch (Exception exception) {
            return false;
        }
        return SectionRepository.isValidRangeInLine(index, lineName);
    }
}
