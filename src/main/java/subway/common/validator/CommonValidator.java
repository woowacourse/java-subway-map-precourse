package subway.common.validator;

import java.util.regex.Pattern;
import subway.common.print.error.CommonErrorPrinter;
import subway.domain.station.StationRepository;

public class CommonValidator {
    public static final int MIN_LENGTH = 2;

    public static boolean isLengthLessThanMinLength(String inputStr) {
        return inputStr.length() < MIN_LENGTH;
    }

    public static boolean isValidSelectionInput(String selectionInputPattern, String userInput) {
        if (!Pattern.matches(selectionInputPattern, userInput)) {
            CommonErrorPrinter.printSelectionInputErrorMessage();
            return false;
        }
        return true;
    }

    public static boolean isExistsStationName(String stationName) {
        return StationRepository.findByName(stationName) != null;
    }
}
