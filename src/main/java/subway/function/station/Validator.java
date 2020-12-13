package subway.function.station;

import subway.common.print.error.CommonErrorPrinter;
import subway.common.validator.CommonValidator;
import subway.domain.LineStationMappingRepository;
import subway.function.station.printer.error.StationManagementErrorPrinter;

public class Validator {
    
    public static boolean isValidStationNameToRegister(String newStationName) {
        if (CommonValidator.isLengthLessThanMinLength(newStationName)) {
            StationManagementErrorPrinter.printNewStationNameLengthThanMinLengthErrorMessage();
            return false;
        }
        if (CommonValidator.isExistsStationName(newStationName)) {
            StationManagementErrorPrinter.printAlreadyExistsStationNameErrorMessage();
            return false;
        }
        return true;
    }

    public static boolean isRegisteredInLineStationName(String stationName) {
        return LineStationMappingRepository.isStationNameRegisteredInLine(stationName);
    }

    public static boolean isValidStationNameToDelete(String stationName) {
        if (!CommonValidator.isExistsStationName(stationName)) {
            CommonErrorPrinter.printNotExistsStationNameErrorMessage();
            return false;
        }
        if (isRegisteredInLineStationName(stationName)) {
            StationManagementErrorPrinter.printRegisteredInLineStationNameErrorMessage();
            return false;
        }
        return true;
    }
}
