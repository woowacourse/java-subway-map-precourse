package subway.function.station;

import java.util.Scanner;
import java.util.regex.Pattern;
import subway.commonprint.error.CommonErrorPrinter;
import subway.commonprint.info.CommonInfoPrinter;
import subway.main.UserSelections;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class StationManagement {
    public static void start(Scanner scanner) {
        String selectionInputPattern = "^[123B]$";
        while (true) {
            printScreen();
            CommonInfoPrinter.printUserFunctionSelectionMessage();
            String userInput = scanner.nextLine();
            if (!Pattern.matches(selectionInputPattern, userInput)) {
                CommonErrorPrinter.printSelectionInputErrorMessage();
                continue;
            }
            StationManagementSelectionType type = getStationManagementSelectionType(userInput);
            resolveStationManagement(type, scanner);
            break;
        }
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

    private static void resolveStationManagement(StationManagementSelectionType type,
        Scanner scanner) {
        if (type == StationManagementSelectionType.STATION_REGISTRATION) {
            registerNewStation(scanner);
        }
        if (type == StationManagementSelectionType.STATION_DELETE) {
            deleteStation(scanner);
        }
        if (type == StationManagementSelectionType.STATION_PRINT_ALL) {
            printAllStations();
        }
    }

    private static void printAllStations() {
        StationRepository.printAll();
    }

    private static void deleteStation(Scanner scanner) {
        StationManagementPrinter.printUserInputStationToDeleteMessage();
        String stationName = scanner.nextLine();
        StationRepository.deleteStation(stationName);
        StationManagementPrinter.printDeleteStationSuccessMessage();
    }

    private static void registerNewStation(Scanner scanner) {
        StationManagementPrinter.printUserInputStationRegistrationMessage();
        String newStationName = scanner.nextLine();
        StationRepository.addStation(new Station(newStationName));
        StationManagementPrinter.printRegisterNewStationSuccessMessage();
    }

    private static void printScreen() {
        PrintStationManagementScreen.printStationManagementScreen();
    }
}
