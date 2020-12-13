package subway.common.validator;

import java.util.regex.Pattern;
import subway.common.print.error.CommonErrorPrinter;
import subway.domain.station.StationRepository;
import subway.function.station.printer.error.StationManagementErrorPrinter;

public class CommonValidator {
    public static final int MIN_LENGTH = 2;
    public static final String SELECTION_INPUT_PATTERN_1234Q = "^[1234Q]$";
    public static final String SELECTION_INPUT_PATTERN_123B = "^[123B]$";

    public static void validateNameMinLength(String inputStr) throws Exception{
        if (inputStr.length() < MIN_LENGTH) {
            StationManagementErrorPrinter.printNewStationNameLengthThanMinLengthErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void validateSelectionInput(String selectionInputPattern, String userInput) throws Exception{
        if (!Pattern.matches(selectionInputPattern, userInput)) {
            CommonErrorPrinter.printSelectionInputErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void validateStationNameExisting(String stationName) throws Exception{
        if (StationRepository.findByName(stationName) == null) {
            StationManagementErrorPrinter.printAlreadyExistsStationNameErrorMessage();
            throw new IllegalArgumentException();
        }
    }
}
