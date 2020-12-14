package subway.function.section.validator;

import java.util.regex.Pattern;
import subway.domain.LineStationMappingRepository;
import subway.domain.line.Line;
import subway.domain.station.Station;
import subway.function.section.printer.error.SectionManagementErrorPrinter;

public class SectionManagementValidator {
    private static final int MIN_LINE_SIZE_TO_DELETE_SECTION = 3;
    private static final int FIRST_ORDER = 1;
    private static final String ORDER_PATTERN = "^\\d+$";

    public static int validateOrderStrToRegisterSection(String orderStrToRegisterSection,
        Line lineToRegisterSection) throws IllegalArgumentException {
        int order = validateIsNumber(orderStrToRegisterSection);
        return validateIsOrderInCorrectRange(order, lineToRegisterSection);
    }

    private static int validateIsOrderInCorrectRange(int order, Line lineToRegisterSection)
        throws IllegalArgumentException {
        int lineSize = LineStationMappingRepository.lineSize(lineToRegisterSection);
        if (!(FIRST_ORDER <= order && order <= FIRST_ORDER + lineSize)) {
            SectionManagementErrorPrinter.printOrderRangeErrorMessage();
            throw new IllegalArgumentException();
        }
        return order;
    }

    private static int validateIsNumber(String orderStrToRegisterSection)
        throws IllegalArgumentException {
        if (!Pattern.matches(ORDER_PATTERN, orderStrToRegisterSection)) {
            SectionManagementErrorPrinter.printOrderNotNumberErrorMessage();
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(orderStrToRegisterSection);
    }

    public static Station validateStationNotInThatLine(
        Station stationToRegisterSection, Line lineToRegisterSection)
        throws IllegalArgumentException {
        if (LineStationMappingRepository
            .isStationRegisteredInThatLine(stationToRegisterSection,
                lineToRegisterSection)) {
            SectionManagementErrorPrinter.printStationAlreadyExistsInLineErrorMessage();
            throw new IllegalArgumentException();
        }
        return stationToRegisterSection;
    }

    public static Station validateStationInThatLine(Station stationToDeleteSection,
        Line lineToDeleteSection) throws IllegalArgumentException {
        if (!LineStationMappingRepository
            .isStationRegisteredInThatLine(stationToDeleteSection,
                lineToDeleteSection)) {
            SectionManagementErrorPrinter.printNotExistsStationInLineErrorMessage();
            throw new IllegalArgumentException();
        }
        return stationToDeleteSection;
    }

    public static Line validateLineHasMoreThanMinSizeToDeleteSection(Line lineToDeleteSection)
        throws IllegalArgumentException {
        if (LineStationMappingRepository.lineSize(lineToDeleteSection)
            < MIN_LINE_SIZE_TO_DELETE_SECTION) {
            SectionManagementErrorPrinter.printNoMoreThanMinStationsExistsInLineErrorMessage();
            throw new IllegalArgumentException();
        }
        return lineToDeleteSection;
    }
}
