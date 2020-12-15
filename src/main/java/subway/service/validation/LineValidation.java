package subway.service.validation;

import java.util.List;
import subway.domain.Station;
import subway.exception.CustomException;
import subway.exception.line.AllStationListIsNotExistException;
import subway.exception.line.LineException;
import subway.exception.line.LineIsAlreadyExistException;
import subway.exception.line.LineIsNotExistException;
import subway.exception.line.LineNameNotOverLimit;
import subway.exception.line.LineNotOverDeleteLimitException;
import subway.exception.line.StationIsNotInLineException;
import subway.exception.line.StationOrderOutOfBoundsException;
import subway.exception.station.StationIsNotExistException;
import subway.service.LineService;
import subway.service.StationService;

public class LineValidation {

    public static boolean checkInsertLine(String lineName, List<Station> stationList) {
        try {
            if (LineService.isUnderNameLength(lineName)) {
                throw new LineNameNotOverLimit();
            }
            if (LineService.isAlreadyExistLine(lineName)) {
                throw new LineIsAlreadyExistException();
            }
            if (StationService.isAllStationListIsExist(stationList)) {
                throw new AllStationListIsNotExistException();
            }
        } catch (CustomException e) {
            e.printError();
            return false;
        }
        return true;
    }

    public static boolean checkDeleteLine(String lineName) {
        try {
            if (!LineService.isAlreadyExistLine(lineName)) {
                throw new LineIsNotExistException();
            }
        } catch (LineException e) {
            e.printError();
            return false;
        }
        return true;
    }

    public static boolean checkInsertStationInLine(String lineName, String stationName, int order) {
        try {
            if (!LineService.isAlreadyExistLine(lineName)) {
                throw new LineIsNotExistException();
            }
            if (!StationService.isAlreadyExistStation(stationName)) {
                throw new StationIsNotExistException();
            }
            if (LineService.isOrderOutOfBounds(lineName, order)) {
                throw new StationOrderOutOfBoundsException();
            }

        } catch (CustomException e) {
            e.printError();
            return false;
        }
        return true;
    }

    public static boolean checkDeleteStationInLine(String lineName, String stationName) {
        try {
            if (!LineService.isAlreadyExistLine(lineName)) {
                throw new LineIsNotExistException();
            }
            if (LineService.isUnderDeleteLimit(lineName)) {
                throw new LineNotOverDeleteLimitException();
            }
            if (!LineService.isStationInLine(lineName, stationName)) {
                throw new StationIsNotInLineException();
            }
        } catch (LineException e) {
            e.printError();
            return false;
        }
        return true;
    }
}
