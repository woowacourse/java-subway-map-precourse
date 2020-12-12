package subway.function.section;

import java.util.Scanner;
import subway.commonprint.CommonPrinter;
import subway.main.UserSelections;

public class SectionManagement {
    public static void start(Scanner scanner) {
        PrintSectionManagementScreen.printSectionManagementScreen();
        CommonPrinter.printUserFunctionSelectionMessage();
        String userInput = scanner.nextLine();
        if (userInput.equals(UserSelections.GO_BACK)) {
            return;
        }
    }
}
