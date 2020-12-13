package subway.function.section;

import java.util.Scanner;
import subway.common.print.info.CommonInfoPrinter;
import subway.common.validator.CommonValidator;
import subway.domain.LineStationMappingRepository;
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

    public static void registerNewSection(Scanner scanner) {
        SectionManagementPrinter.printLineNameToRegisterSectionInputMessage();
        String lineNameToRegisterSection = scanner.nextLine();

        SectionManagementPrinter.printStationNameToRegisterSectionInputMessage();
        String stationNameToRegisterSection = scanner.nextLine();

        SectionManagementPrinter.printOrderToRegisterInputMessage();
        String orderToRegisterSection = scanner.nextLine();

        LineStationMappingRepository
            .registerNewSection(lineNameToRegisterSection, stationNameToRegisterSection,
                orderToRegisterSection);

        SectionManagementPrinter.printSectionRegistrationSuccessMessage();
    }

    public static void deleteSection(Scanner scanner) {
        SectionManagementPrinter.printLineNameToDeleteSectionInputMessage();
        String lineNameToDeleteSection = scanner.nextLine();

        SectionManagementPrinter.printStationNameToDeleteSectionInputMessage();
        String stationNameToDeleteSection = scanner.nextLine();

        LineStationMappingRepository
            .deleteSection(lineNameToDeleteSection, stationNameToDeleteSection);

        SectionManagementPrinter.printSectionDeleteSuccessMessage();
    }


}
