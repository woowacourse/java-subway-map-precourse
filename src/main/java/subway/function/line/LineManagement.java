package subway.function.line;

import java.util.Scanner;
import subway.main.UserSelections;

public class LineManagement {
    public static void start(Scanner scanner) {
        PrintLineManagementScreen.printLineManagementScreen();
        String userInput = scanner.nextLine();
        if (userInput.equals(UserSelections.GO_BACK)) {
            return;
        }
        LineManagementSelectionType type = getLineManagementSelectionType(userInput);
        resolveUserSelection(type, scanner);
    }

    private static void resolveUserSelection(LineManagementSelectionType type, Scanner scanner) {
        if (type == LineManagementSelectionType.LINE_REGISTRATION) {
            //registerNewLine(scanner);
        }
        if (type == LineManagementSelectionType.LINE_DELETE) {
            //deleteLine(scanner);
        }
        if (type == LineManagementSelectionType.PRINT_ALL_LINES) {
            //printAllLines(scanner);
        }
    }

    private static void registerNewLine(Scanner scanner) {

    }

    private static LineManagementSelectionType getLineManagementSelectionType(String userInput) {
        if (userInput.equals(UserSelections.FIRST)) {
            return LineManagementSelectionType.LINE_REGISTRATION;
        }
        if (userInput.equals(UserSelections.SECOND)) {
            return LineManagementSelectionType.LINE_DELETE;
        }
        return LineManagementSelectionType.PRINT_ALL_LINES;
    }
}
