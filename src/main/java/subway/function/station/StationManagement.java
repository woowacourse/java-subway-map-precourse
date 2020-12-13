package subway.function.station;

import java.util.Scanner;
import subway.common.ResolveResultType;
import subway.common.print.info.CommonInfoPrinter;
import subway.function.station.printer.PrintStationManagementScreen;
import subway.function.station.printer.StationManagementPrinter;
import subway.main.UserSelections;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class StationManagement {
    public static void start(Scanner scanner) {
        String selectionInputPattern = "^[123B]$";
        while (true) {
            String userInput = printAndGetUserSelectionInput(scanner);
            if (!Validator.isValidSelectionInput(selectionInputPattern, userInput)) {
                continue;
            }
            StationManagementSelectionType type = getStationManagementSelectionType(userInput);
            if (type == StationManagementSelectionType.GO_BACK) {
                break;
            }
            ResolveResultType result = resolveStationManagement(type, scanner);
            if (result == ResolveResultType.ERROR) {
                continue;
            }
            break;
        }
    }

    private static String printAndGetUserSelectionInput(Scanner scanner) {
        printScreen();
        CommonInfoPrinter.printUserFunctionSelectionMessage();
        return scanner.nextLine();
    }

    private static StationManagementSelectionType getStationManagementSelectionType(
        String userInput) {
        if (userInput.equals(UserSelections.FIRST)) {
            return StationManagementSelectionType.STATION_REGISTRATION;
        }
        if (userInput.equals(UserSelections.SECOND)) {
            return StationManagementSelectionType.STATION_DELETE;
        }
        if (userInput.equals(UserSelections.THIRD)) {
            return StationManagementSelectionType.STATION_PRINT_ALL;
        }
        return StationManagementSelectionType.GO_BACK;
    }

    private static ResolveResultType resolveStationManagement(StationManagementSelectionType type,
        Scanner scanner) {
        if (type == StationManagementSelectionType.STATION_REGISTRATION) {
            return registerNewStation(scanner);
        }
        if (type == StationManagementSelectionType.STATION_DELETE) {
            return deleteStation(scanner);
        }
        if (type == StationManagementSelectionType.STATION_PRINT_ALL) {
            return printAllStations();
        }
        return ResolveResultType.ERROR;
    }

    private static ResolveResultType printAllStations() {
        StationRepository.printAll();
        return ResolveResultType.SUCCESS;
    }

    private static ResolveResultType deleteStation(Scanner scanner) {
        StationManagementPrinter.printUserInputStationToDeleteMessage();
        String stationName = scanner.nextLine();
        if (!Validator.isValidStationNameToDelete(stationName)) {
            return ResolveResultType.ERROR;
        }
        StationRepository.deleteStation(stationName);
        StationManagementPrinter.printDeleteStationSuccessMessage();
        return ResolveResultType.SUCCESS;
    }

    private static ResolveResultType registerNewStation(Scanner scanner) {
        StationManagementPrinter.printUserInputStationRegistrationMessage();
        String newStationName = scanner.nextLine();
        if (!Validator.isValidStationNameToRegister(newStationName)) {
            return ResolveResultType.ERROR;
        }
        StationRepository.addStation(new Station(newStationName));
        StationManagementPrinter.printRegisterNewStationSuccessMessage();
        return ResolveResultType.SUCCESS;
    }

    private static void printScreen() {
        PrintStationManagementScreen.printStationManagementScreen();
    }
}
