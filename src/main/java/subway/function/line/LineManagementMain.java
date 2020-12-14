package subway.function.line;

import java.util.Scanner;
import subway.common.print.info.CommonInfoPrinter;
import subway.common.validator.CommonValidator;
import subway.function.line.printer.PrintLineManagementScreen;
import subway.function.line.type.LineManagementSelectionType;
import subway.function.line.type.LineManagementTypeResolver;

public class LineManagementMain {
    public static void start(Scanner scanner) {
        while (true) {
            LineManagementSelectionType type = null;
            try {
                type = printAndGetUserSelection(scanner);
                LineManagementTypeResolver.resolveUserSelection(type, scanner);
            } catch (IllegalArgumentException e) {
                continue;
            }
            return;
        }
    }

    private static LineManagementSelectionType printAndGetUserSelection(Scanner scanner)
        throws IllegalArgumentException {
        PrintLineManagementScreen.printLineManagementScreen();
        CommonInfoPrinter.printUserFunctionSelectionMessage();
        String userInput = scanner.nextLine();
        CommonValidator
            .validateIsCorrectSelectionInput(CommonValidator.SELECTION_INPUT_PATTERN_123B,
                userInput);
        return LineManagementTypeResolver.getLineManagementSelectionType(userInput);
    }
}
