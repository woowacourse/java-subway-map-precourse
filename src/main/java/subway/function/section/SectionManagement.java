package subway.function.section;

import java.util.Scanner;
import subway.common.print.info.CommonInfoPrinter;
import subway.domain.LineStationMappingRepository;
import subway.main.UserSelections;

public class SectionManagement {
    public static void start(Scanner scanner) {
        PrintSectionManagementScreen.printSectionManagementScreen();
        CommonInfoPrinter.printUserFunctionSelectionMessage();
        String userInput = scanner.nextLine();
        if (userInput.equals(UserSelections.GO_BACK)) {
            return;
        }
        SectionManagementType type = getSectionManagementType(userInput);
        resolveSectionManagement(type, scanner);
    }

    private static void resolveSectionManagement(SectionManagementType type, Scanner scanner) {
        if (type == SectionManagementType.SECTION_REGISTRATION) {
            registerNewSection(scanner);
        }
        if (type == SectionManagementType.DELETE_SECTION) {
            deleteSection(scanner);
        }
    }

    private static void deleteSection(Scanner scanner) {
        SectionManagementPrinter.printLineNameToDeleteSectionInputMessage();
        String lineNameToDeleteSection = scanner.nextLine();

        SectionManagementPrinter.printStationNameToDeleteSectionInputMessage();
        String stationNameToDeleteSection = scanner.nextLine();

        LineStationMappingRepository
            .deleteSection(lineNameToDeleteSection, stationNameToDeleteSection);

        SectionManagementPrinter.printSectionDeleteSuccessMessage();
    }

    private static void registerNewSection(Scanner scanner) {
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

    private static SectionManagementType getSectionManagementType(String userInput) {
        if (userInput.equals(UserSelections.FIRST)) {
            return SectionManagementType.SECTION_REGISTRATION;
        }
        return SectionManagementType.DELETE_SECTION;
    }
}
