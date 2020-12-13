package subway.function.station;

import subway.common.validator.CommonValidator;
import subway.domain.LineStationMappingRepository;
import subway.function.station.printer.error.StationManagementErrorPrinter;

public class StationManagementValidator {

    public static void validateStationNameToRegister(String newStationName) throws Exception {
        CommonValidator.validateIsNameLengthMinLengthOrMore(newStationName);
        CommonValidator.validateIsNotStationNameExisting(newStationName);
    }

    public static void validateRegisteredInLineStationName(String stationName) throws Exception {
        if (LineStationMappingRepository.isStationNameRegisteredInLine(stationName)) {
            StationManagementErrorPrinter.printRegisteredInLineStationNameErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void validateStationNameToDelete(String stationName) throws Exception {
        CommonValidator.validateIsStationNameExisting(stationName);
        validateRegisteredInLineStationName(stationName);
    }
}
