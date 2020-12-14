package subway.function.station;

import java.util.Scanner;
import subway.common.print.info.CommonInfoPrinter;
import subway.common.validator.CommonValidator;
import subway.function.station.printer.PrintStationManagementScreen;
import subway.function.station.type.StationManagementSelectionType;
import subway.function.station.type.StationManagementTypeResolver;

public class StationManagementMain {
    public static void start(Scanner scanner) {
        while (true) {
            StationManagementSelectionType type = null;
            type = printAndGetUserSelectionInput(scanner);
            if (type == StationManagementSelectionType.GO_BACK) {
                return;
            }
            StationManagementTypeResolver.resolveStationManagement(type, scanner);
        }
    }

    private static void printScreen() {
        PrintStationManagementScreen.printStationManagementScreen();
    }

    private static StationManagementSelectionType printAndGetUserSelectionInput(Scanner scanner) {
        printScreen();
        CommonInfoPrinter.printUserFunctionSelectionMessage();
        String userInput = scanner.nextLine();
        try {
            CommonValidator
                .validateIsCorrectSelectionInput(CommonValidator.SELECTION_INPUT_PATTERN_123B,
                    userInput);
        } catch (IllegalArgumentException e) {
            return StationManagementSelectionType.ERROR;
        }
        return StationManagementTypeResolver.getStationManagementSelectionType(userInput);
    }
}
