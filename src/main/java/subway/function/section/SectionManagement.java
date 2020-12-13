package subway.function.section;

import java.util.Scanner;
import subway.common.print.info.CommonInfoPrinter;
import subway.common.validator.CommonValidator;
import subway.domain.LineStationMappingRepository;
import subway.domain.line.Line;
import subway.domain.station.Station;
import subway.function.section.printer.PrintSectionManagementScreen;
import subway.function.section.printer.SectionManagementPrinter;

public class SectionManagement {
    public static void start(Scanner scanner) {
        while (true) {
            SectionManagementType type = printAndGetUserSelectionInput(scanner);
            if (type == SectionManagementType.GO_BACK) {
                return;
            }
            SectionManagementTypeResolver.resolveSectionManagement(type, scanner);
        }
    }

    private static SectionManagementType printAndGetUserSelectionInput(Scanner scanner) {
        PrintSectionManagementScreen.printSectionManagementScreen();
        CommonInfoPrinter.printUserFunctionSelectionMessage();
        String userInput = scanner.nextLine();
        try {
            CommonValidator
                .validateIsCorrectSelectionInput(CommonValidator.SELECTION_INPUT_PATTERN_12B,
                    userInput);
        } catch (IllegalArgumentException e) {
            return SectionManagementType.ERROR;
        }
        return SectionManagementTypeResolver.getSectionManagementType(userInput);
    }

    public static void registerNewSection(Scanner scanner) throws IllegalArgumentException {
        Line lineToRegisterSection = getLineToRegisterSection(scanner);
        Station stationToRegisterSection = getStationToRegisterSection(scanner,
            lineToRegisterSection);
        int orderToRegisterSection = getOrderToRegisterSection(scanner, lineToRegisterSection);
        LineStationMappingRepository
            .registerNewSectionByLineAndStation(lineToRegisterSection, stationToRegisterSection,
                orderToRegisterSection);
        SectionManagementPrinter.printSectionRegistrationSuccessMessage();
    }

    private static Line getLineToRegisterSection(Scanner scanner) {
        SectionManagementPrinter.printLineNameToRegisterSectionInputMessage();
        String lineNameToRegisterSection = scanner.nextLine();
        return CommonValidator.validateIsLineNameExists(lineNameToRegisterSection);
    }

    private static Station getStationToRegisterSection(Scanner scanner,
        Line lineToRegisterSection) {
        SectionManagementPrinter.printStationNameToRegisterSectionInputMessage();
        String stationNameToRegisterSection = scanner.nextLine();
        Station stationToRegisterSection = CommonValidator
            .validateIsStationNameExists(stationNameToRegisterSection);
        return SectionManagementValidator
            .validateStationNotInThatLine(stationToRegisterSection, lineToRegisterSection);
    }

    private static int getOrderToRegisterSection(Scanner scanner,
        Line lineToRegisterSection) {
        SectionManagementPrinter.printOrderToRegisterInputMessage();
        String orderStrToRegisterSection = scanner.nextLine();
        return SectionManagementValidator
            .validateOrderStrToRegisterSection(orderStrToRegisterSection, lineToRegisterSection);
    }

    public static void deleteSection(Scanner scanner) throws IllegalArgumentException {
        SectionManagementPrinter.printLineNameToDeleteSectionInputMessage();
        String lineNameToDeleteSection = scanner.nextLine();

        SectionManagementPrinter.printStationNameToDeleteSectionInputMessage();
        String stationNameToDeleteSection = scanner.nextLine();

        LineStationMappingRepository
            .deleteSection(lineNameToDeleteSection, stationNameToDeleteSection);

        SectionManagementPrinter.printSectionDeleteSuccessMessage();
    }


}
