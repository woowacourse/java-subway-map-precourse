package subway.function.section.management;

import java.util.Scanner;
import subway.common.validator.CommonValidator;
import subway.domain.LineStationMappingRepository;
import subway.domain.line.Line;
import subway.domain.station.Station;
import subway.function.section.printer.SectionManagementPrinter;
import subway.function.section.validator.SectionManagementValidator;

public class RegisterNewSection {
    public static void registerNewSection(Scanner scanner) throws IllegalArgumentException {
        Line lineToRegisterSection = getLineToRegisterNewSection(scanner);
        Station stationToRegisterSection = getStationToRegisterNewSection(scanner,
            lineToRegisterSection);
        int orderToRegisterSection = getOrderToRegisterNewSection(scanner, lineToRegisterSection);
        LineStationMappingRepository
            .registerNewSectionByLineAndStation(lineToRegisterSection, stationToRegisterSection,
                orderToRegisterSection);
        SectionManagementPrinter.printSectionRegistrationSuccessMessage();
    }

    private static Line getLineToRegisterNewSection(Scanner scanner) {
        SectionManagementPrinter.printLineNameToRegisterSectionInputMessage();
        String lineNameToRegisterSection = scanner.nextLine();
        return CommonValidator.validateIsLineNameExists(lineNameToRegisterSection);
    }

    private static Station getStationToRegisterNewSection(Scanner scanner,
        Line lineToRegisterSection) {
        SectionManagementPrinter.printStationNameToRegisterSectionInputMessage();
        String stationNameToRegisterSection = scanner.nextLine();
        Station stationToRegisterSection = CommonValidator
            .validateIsStationNameExists(stationNameToRegisterSection);
        return SectionManagementValidator
            .validateStationNotInThatLine(stationToRegisterSection, lineToRegisterSection);
    }

    private static int getOrderToRegisterNewSection(Scanner scanner,
        Line lineToRegisterSection) {
        SectionManagementPrinter.printOrderToRegisterInputMessage();
        String orderStrToRegisterSection = scanner.nextLine();
        return SectionManagementValidator
            .validateOrderStrToRegisterSection(orderStrToRegisterSection, lineToRegisterSection);
    }
}
