package subway.service.validation;

import subway.exception.station.StationException;
import subway.exception.station.StationIsAlreadyException;
import subway.exception.station.StationIsNotExistException;
import subway.exception.station.StationIsRegisteredException;
import subway.exception.station.StationNameNotOverLimit;
import subway.service.StationService;

public class StationValidation {

    public static boolean checkInsertStation(String stationName) {
        try {
            if (StationService.isUnderNameLength(stationName)) {
                throw new StationNameNotOverLimit();
            }
            if (StationService.isAlreadyExistStation(stationName)) {
                throw new StationIsAlreadyException();
            }
        } catch (StationException e) {
            e.printError();
            return false;
        }
        return true;
    }

    public static boolean checkDeleteStation(String stationName) {
        try {
            if (StationService.isUnderNameLength(stationName)) {
                throw new StationNameNotOverLimit();
            }
            if (!StationService.isAlreadyExistStation(stationName)) {
                throw new StationIsNotExistException();
            }
            if (StationService.isRegisteredStation(stationName)) {
                throw new StationIsRegisteredException();
            }
        } catch (StationException e) {
            e.printError();
            return false;
        }
        return true;
    }
}
