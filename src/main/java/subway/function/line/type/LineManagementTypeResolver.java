package subway.function.line.type;

import java.util.Scanner;
import subway.function.line.management.DeleteLine;
import subway.function.line.management.PrintAllLinesList;
import subway.function.line.management.RegisterNewLine;
import subway.main.type.UserSelections;

public class LineManagementTypeResolver {
    public static LineManagementSelectionType getLineManagementSelectionType(String userInput) {
        if (userInput.equals(UserSelections.FIRST)) {
            return LineManagementSelectionType.LINE_REGISTRATION;
        }
        if (userInput.equals(UserSelections.SECOND)) {
            return LineManagementSelectionType.LINE_DELETE;
        }
        if (userInput.equals(UserSelections.THIRD)) {
            return LineManagementSelectionType.PRINT_ALL_LINES;
        }
        return LineManagementSelectionType.GO_BACK;
    }

    public static void resolveUserSelection(LineManagementSelectionType type, Scanner scanner) {
        if (type == LineManagementSelectionType.LINE_REGISTRATION) {
            RegisterNewLine.registerNewLine(scanner);
        }
        if (type == LineManagementSelectionType.LINE_DELETE) {
            DeleteLine.deleteLine(scanner);
        }
        if (type == LineManagementSelectionType.PRINT_ALL_LINES) {
            PrintAllLinesList.printAllLinesList();
        }
    }
}
