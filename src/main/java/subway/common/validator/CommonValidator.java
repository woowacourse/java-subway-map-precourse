package subway.common.validator;

import java.util.regex.Pattern;
import subway.common.print.error.CommonErrorPrinter;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.function.station.printer.error.StationManagementErrorPrinter;

public class CommonValidator {
    public static final int MIN_LENGTH = 2;
    public static final String SELECTION_INPUT_PATTERN_1234Q = "^[1234Q]$";
    public static final String SELECTION_INPUT_PATTERN_123B = "^[123B]$";

    public static void validateIsCorrectSelectionInput(String selectionInputPattern,
        String userInput) throws IllegalArgumentException {
        if (!Pattern.matches(selectionInputPattern, userInput)) {
            CommonErrorPrinter.printSelectionInputErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsNotStationNameExists(String stationName) throws IllegalArgumentException {
        if (StationRepository.findByName(stationName) != null) {
            StationManagementErrorPrinter.printAlreadyExistsStationNameErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public static Station validateIsStationNameExists(String stationName) throws IllegalArgumentException {
        Station foundStation = StationRepository.findByName(stationName);
        if (foundStation == null) {
            CommonErrorPrinter.printNotExistsStationNameErrorMessage();
            throw new IllegalArgumentException();
        }
        return foundStation;
    }

    public static Line validateIsLineNameExists(String lineName) throws IllegalArgumentException {
        Line foundLine = LineRepository.findByName(lineName);
        if (foundLine == null) {
            CommonErrorPrinter.printNotExistsLineNameErrorMessage();
            throw new IllegalArgumentException();
        }
        return foundLine;
    }
}
