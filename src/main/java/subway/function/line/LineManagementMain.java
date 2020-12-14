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
            type = printAndGetUserSelection(scanner);
            if (type == LineManagementSelectionType.GO_BACK) {
                return;
            }
            LineManagementTypeResolver.resolveUserSelection(type, scanner);
        }
    }

    private static LineManagementSelectionType printAndGetUserSelection(Scanner scanner) {
        PrintLineManagementScreen.printLineManagementScreen();
        CommonInfoPrinter.printUserFunctionSelectionMessage();
        String userInput = scanner.nextLine();
        try {
            CommonValidator
                .validateIsCorrectSelectionInput(CommonValidator.SELECTION_INPUT_PATTERN_123B,
                    userInput);
        } catch (IllegalArgumentException e) {
            return LineManagementSelectionType.ERROR;
        }
        return LineManagementTypeResolver.getLineManagementSelectionType(userInput);
    }
}
