package subway.function.section;

import java.util.Scanner;
import subway.common.print.info.CommonInfoPrinter;
import subway.common.validator.CommonValidator;
import subway.function.section.printer.PrintSectionManagementScreen;
import subway.function.section.type.SectionManagementType;
import subway.function.section.type.SectionManagementTypeResolver;

public class SectionManagementMain {
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
}
