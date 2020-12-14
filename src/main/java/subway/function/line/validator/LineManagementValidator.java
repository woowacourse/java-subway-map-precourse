package subway.function.line.validator;

import subway.common.validator.CommonValidator;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.function.line.printer.error.LineManagementErrorPrinter;

public class LineManagementValidator {
    public static void validateIsLineNameNotExists(String lineName)
        throws IllegalArgumentException {
        if (LineRepository.findByName(lineName) != null) {
            LineManagementErrorPrinter.printNewLineNameAlreadyExistsErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsNotEqual(Station upEndStation, Station downEndStation)
        throws IllegalArgumentException {
        if (upEndStation.getName().equals(downEndStation.getName())) {
            LineManagementErrorPrinter.printUpAndDownEndStationEqualErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsLineNameLengthMinLengthOrMore(String newLineName)
        throws IllegalArgumentException {
        if (newLineName.length() < CommonValidator.MIN_LENGTH) {
            LineManagementErrorPrinter.printNewLineNameLessThanMinLengthErrorMessage();
            throw new IllegalArgumentException();
        }
    }
}
