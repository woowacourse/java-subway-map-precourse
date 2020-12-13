package subway.function.line;

import java.util.Scanner;
import subway.common.print.info.CommonInfoPrinter;
import subway.domain.line.LineRepository;
import subway.domain.LineStationMappingRepository;
import subway.main.UserSelections;

public class LineManagement {
    public static void start(Scanner scanner) {
        PrintLineManagementScreen.printLineManagementScreen();
        CommonInfoPrinter.printUserFunctionSelectionMessage();
        String userInput = scanner.nextLine();
        if (userInput.equals(UserSelections.GO_BACK)) {
            return;
        }
        LineManagementSelectionType type = getLineManagementSelectionType(userInput);
        resolveUserSelection(type, scanner);
    }

    private static void resolveUserSelection(LineManagementSelectionType type, Scanner scanner) {
        if (type == LineManagementSelectionType.LINE_REGISTRATION) {
            registerNewLine(scanner);
        }
        if (type == LineManagementSelectionType.LINE_DELETE) {
            deleteLine(scanner);
        }
        if (type == LineManagementSelectionType.PRINT_ALL_LINES) {
            printLineList();
        }
    }

    private static void printLineList() {
        LineManagementPrinter.printLineListTitle();
        LineRepository.printAllLines();
    }

    private static void deleteLine(Scanner scanner) {
        LineManagementPrinter.printLineNameToDeleteInputMessage();
        String lineNameToDeleteInput = scanner.nextLine();
        LineStationMappingRepository.deleteLine(lineNameToDeleteInput);
        LineManagementPrinter.printLineDeleteSuccessMessage();
    }

    private static void registerNewLine(Scanner scanner) {
        LineManagementPrinter.printNewLineNameInputMessage();
        String newLineNameInput = scanner.nextLine();

        LineManagementPrinter.printLineUpEndStationNameInputMessage();
        String upEndStationNameInput = scanner.nextLine();

        LineManagementPrinter.printLineDownEndStationNameInputMessage();
        String downEndStationNameInput = scanner.nextLine();

        LineStationMappingRepository
            .createNewLine(newLineNameInput, upEndStationNameInput, downEndStationNameInput);

        LineManagementPrinter.printNewLineRegistrationSuccessMessage();
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
