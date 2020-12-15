package subway.exception;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationExceptionManager extends ExceptionManager {
    public static Error checkValidStationRegister(String name) {
        if (!Station.isValidName(name)) {
            return Error.INVALID_STATION_NAME_LENGTH;
        }
        if (StationRepository.hasStation(name)) {
            return Error.DUPLICATE_STATION_NAME;
        }
        return Error.OK;
    }

    public static Error checkValidStationRemoval(String name) {
        if (!Station.isValidName(name)) {
            return Error.INVALID_STATION_NAME_LENGTH;
        }
        if (!StationRepository.hasStation(name)) {
            return Error.NON_EXISTENT_STATION_NAME;
        }
        if (!StationRepository.isRemovable(name)) {
            return Error.INVALID_STATION_REMOVAL;
        }
        return Error.OK;
    }
}
