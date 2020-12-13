package subway.function.station;

import java.util.Scanner;
import subway.common.ResolveResultType;
import subway.common.print.info.CommonInfoPrinter;
import subway.common.validator.CommonValidator;
import subway.function.station.printer.PrintStationManagementScreen;
import subway.function.station.printer.StationManagementPrinter;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class StationManagement {

    public static void start(Scanner scanner) {
        String selectionInputPattern = "^[123B]$";
        while (true) {
            String userInput = printAndGetUserSelectionInput(scanner);
            if (!CommonValidator.isValidSelectionInput(selectionInputPattern, userInput)) {
                continue;
            }
            StationManagementSelectionType type = TypeResolver
                .getStationManagementSelectionType(userInput);
            if (type == StationManagementSelectionType.GO_BACK) {
                break;
            }
            ResolveResultType result = TypeResolver.resolveStationManagement(type, scanner);
            if (result == ResolveResultType.ERROR) {
                continue;
            }
            break;
        }
    }

    private static void printScreen() {
        PrintStationManagementScreen.printStationManagementScreen();
    }

    private static String printAndGetUserSelectionInput(Scanner scanner) {
        printScreen();
        CommonInfoPrinter.printUserFunctionSelectionMessage();
        return scanner.nextLine();
    }

    public static ResolveResultType registerNewStation(Scanner scanner) {
        StationManagementPrinter.printUserInputStationRegistrationMessage();
        String newStationName = scanner.nextLine();
        if (!Validator.isValidStationNameToRegister(newStationName)) {
            return ResolveResultType.ERROR;
        }
        StationRepository.addStation(new Station(newStationName));
        StationManagementPrinter.printRegisterNewStationSuccessMessage();
        return ResolveResultType.SUCCESS;
    }

    public static ResolveResultType deleteStation(Scanner scanner) {
        StationManagementPrinter.printUserInputStationToDeleteMessage();
        String stationName = scanner.nextLine();
        if (!Validator.isValidStationNameToDelete(stationName)) {
            return ResolveResultType.ERROR;
        }
        StationRepository.deleteStation(stationName);
        StationManagementPrinter.printDeleteStationSuccessMessage();
        return ResolveResultType.SUCCESS;
    }

    public static ResolveResultType printAllStations() {
        StationRepository.printAll();
        return ResolveResultType.SUCCESS;
    }
}
