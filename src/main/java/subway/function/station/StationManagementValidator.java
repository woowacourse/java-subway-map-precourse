package subway.function.station;

import subway.common.validator.CommonValidator;
import subway.domain.LineStationMappingRepository;
import subway.function.station.printer.error.StationManagementErrorPrinter;

public class StationManagementValidator {

    public static void validateStationNameToRegister(String newStationName) throws Exception {
        CommonValidator.validateNameMinLength(newStationName);
        CommonValidator.validateStationNameExisting(newStationName);
    }

    public static void validateRegisteredInLineStationName(String stationName) throws Exception {
        if (LineStationMappingRepository.isStationNameRegisteredInLine(stationName)) {
            throw new IllegalArgumentException();
        }
        StationManagementErrorPrinter.printRegisteredInLineStationNameErrorMessage();
    }

    public static void validateStationNameToDelete(String stationName) throws Exception {
        CommonValidator.validateStationNameExisting(stationName);
        validateRegisteredInLineStationName(stationName);
    }
}
