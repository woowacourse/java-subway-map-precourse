package subway.function.section.management;

import java.util.Scanner;
import subway.common.validator.CommonValidator;
import subway.domain.LineStationMappingRepository;
import subway.domain.line.Line;
import subway.domain.station.Station;
import subway.function.section.printer.SectionManagementPrinter;
import subway.function.section.validator.SectionManagementValidator;

public class DeleteSection {
    public static void deleteSection(Scanner scanner) throws IllegalArgumentException {
        Line lineToDeleteSection = getLineToDeleteSection(scanner);
        Station stationToDeleteSection = getStationToDeleteSection(scanner, lineToDeleteSection);
        LineStationMappingRepository
            .deleteSection(lineToDeleteSection, stationToDeleteSection);
        SectionManagementPrinter.printSectionDeleteSuccessMessage();
    }

    private static Line getLineToDeleteSection(Scanner scanner) throws IllegalArgumentException {
        SectionManagementPrinter.printLineNameToDeleteSectionInputMessage();
        String lineNameToDeleteSection = scanner.nextLine();
        Line lineToDeleteSection = CommonValidator
            .validateIsLineNameExists(lineNameToDeleteSection);
        return SectionManagementValidator
            .validateLineHasMoreThanMinSizeToDeleteSection(lineToDeleteSection);
    }

    private static Station getStationToDeleteSection(Scanner scanner,
        Line lineToRegisterSection) throws IllegalArgumentException {
        SectionManagementPrinter.printStationNameToDeleteSectionInputMessage();
        String stationNameToDeleteSection = scanner.nextLine();
        Station stationToDeleteSection = CommonValidator
            .validateIsStationNameExists(stationNameToDeleteSection);
        return SectionManagementValidator
            .validateStationInThatLine(stationToDeleteSection, lineToRegisterSection);
    }
}
