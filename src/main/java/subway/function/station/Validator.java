package subway.function.station;

import java.util.regex.Pattern;
import subway.common.print.error.CommonErrorPrinter;
import subway.common.validator.CommonValidator;
import subway.domain.LineStationMappingRepository;
import subway.domain.station.StationRepository;
import subway.function.station.printer.error.StationManagementErrorPrinter;

public class Validator {

    public static boolean isValidSelectionInput(String selectionInputPattern, String userInput) {
        if (!Pattern.matches(selectionInputPattern, userInput)) {
            CommonErrorPrinter.printSelectionInputErrorMessage();
            return false;
        }
        return true;
    }

    public static boolean isValidStationNameToRegister(String newStationName) {
        if (CommonValidator.isLengthLessThanMinLength(newStationName)) {
            StationManagementErrorPrinter.printNewStationNameLengthErrorMessage();
            return false;
        }
        if (isExistsStationName(newStationName)) {
            StationManagementErrorPrinter.printAlreadyExistsStationNameErrorMessage();
            return false;
        }
        return true;
    }

    public static boolean isExistsStationName(String stationName) {
        return StationRepository.findByName(stationName) != null;
    }

    public static boolean isRegisteredInLineStationName(String stationName) {
        return LineStationMappingRepository.isStationNameRegisteredInLine(stationName);
    }

    public static boolean isValidStationNameToDelete(String stationName) {
        if (!isExistsStationName(stationName)) {
            StationManagementErrorPrinter.printNotExistsStationNameErrorMessage();
            return false;
        }
        if (isRegisteredInLineStationName(stationName)) {
            StationManagementErrorPrinter.printRegisteredInLineStationNameErrorMessage();
            return false;
        }
        return true;
    }
}
