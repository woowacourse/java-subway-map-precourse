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
            try {
                SectionManagementType type = printAndGetUserSelectionInput(scanner);
                SectionManagementTypeResolver.resolveSectionManagement(type, scanner);
            } catch (IllegalArgumentException e) {
                continue;
            }
            return;
        }
    }

    private static SectionManagementType printAndGetUserSelectionInput(Scanner scanner)
        throws IllegalArgumentException {
        PrintSectionManagementScreen.printSectionManagementScreen();
        CommonInfoPrinter.printUserFunctionSelectionMessage();
        String userInput = scanner.nextLine();
        CommonValidator
            .validateIsCorrectSelectionInput(CommonValidator.SELECTION_INPUT_PATTERN_12B,
                userInput);
        return SectionManagementTypeResolver.getSectionManagementType(userInput);
    }
}
