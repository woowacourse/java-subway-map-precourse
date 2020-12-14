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
            try {
                type = printAndGetUserSelectionInput(scanner);
                StationManagementTypeResolver.resolveStationManagement(type, scanner);
            } catch (IllegalArgumentException e) {
                continue;
            }
            return;
        }
    }

    private static void printScreen() {
        PrintStationManagementScreen.printStationManagementScreen();
    }

    private static StationManagementSelectionType printAndGetUserSelectionInput(Scanner scanner)
        throws IllegalArgumentException {
        printScreen();
        CommonInfoPrinter.printUserFunctionSelectionMessage();
        String userInput = scanner.nextLine();
        CommonValidator
            .validateIsCorrectSelectionInput(CommonValidator.SELECTION_INPUT_PATTERN_123B,
                userInput);
        return StationManagementTypeResolver.getStationManagementSelectionType(userInput);
    }
}
