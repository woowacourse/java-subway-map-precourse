package subway.function.line.management;

import java.util.Scanner;
import subway.common.validator.CommonValidator;
import subway.domain.LineStationMappingRepository;
import subway.function.line.printer.LineManagementPrinter;

public class DeleteLine {
    public static void deleteLine(Scanner scanner) throws IllegalArgumentException {
        LineManagementPrinter.printLineNameToDeleteInputMessage();
        String lineNameToDeleteInput = scanner.nextLine();
        CommonValidator.validateIsLineNameExists(lineNameToDeleteInput);
        LineStationMappingRepository.deleteLine(lineNameToDeleteInput);
        LineManagementPrinter.printLineDeleteSuccessMessage();
    }
}
