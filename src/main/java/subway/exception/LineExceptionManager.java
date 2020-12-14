package subway.exception;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class LineExceptionManager extends ExceptionManager {
    public static Error checkAccessibleLineRepository() {
        if (LineRepository.isEmpty()) {
            return Error.INVALID_COMMAND;
        }
        return Error.OK;
    }

    public static Error checkValidLineRegister(String name) {
        if (!isValidLineNameLength(name)) {
            return Error.INVALID_LINE_NAME_LENGTH;
        }
        if (LineRepository.hasLine(name)) {
            return Error.DUPLICATE_LINE_NAME;
        }
        return Error.OK;
    }

    public static Error checkValidTerminatingStation(String name) {
        if (!isValidStationNameLength(name)) {
            return Error.INVALID_STATION_NAME_LENGTH;
        }
        if (!StationRepository.hasStation(name)) {
            return Error.NON_EXISTENT_STATION_NAME;
        }
        return Error.OK;
    }

    public static Error checkValidLineRemoval(String name) {
        if (!isValidLineNameLength(name)) {
            return Error.INVALID_LINE_NAME_LENGTH;
        }
        if (!LineRepository.hasLine(name)) {
            return Error.NON_EXISTENT_LINE_NAME;
        }
        return Error.OK;
    }

    public static Error checkValidTerminatingStationPair(String upboundStation,
            String downboundStation) {
        if (upboundStation.equals(downboundStation)) {
            return Error.SAME_TERMINATING_STATION;
        }
        return Error.OK;
    }
}
