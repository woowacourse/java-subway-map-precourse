package subway.function.station.validator;

import subway.common.validator.CommonValidator;
import subway.domain.LineStationMappingRepository;
import subway.function.station.printer.error.StationManagementErrorPrinter;

public class StationManagementValidator {
    public static void validateIsStationNameLengthMinLengthOrMore(String stationName)
        throws IllegalArgumentException {
        if (stationName.length() < CommonValidator.MIN_LENGTH) {
            StationManagementErrorPrinter.printNewStationNameLengthThanMinLengthErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void validateStationNameToRegister(String newStationName)
        throws IllegalArgumentException {
        validateIsStationNameLengthMinLengthOrMore(newStationName);
        CommonValidator.validateIsNotStationNameExists(newStationName);
    }

    public static void validateRegisteredInLineStationName(String stationName)
        throws IllegalArgumentException {
        if (LineStationMappingRepository.isStationNameRegisteredInLine(stationName)) {
            StationManagementErrorPrinter.printRegisteredInLineStationNameErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void validateStationNameToDelete(String stationName)
        throws IllegalArgumentException {
        CommonValidator.validateIsStationNameExists(stationName);
        validateRegisteredInLineStationName(stationName);
    }
}
