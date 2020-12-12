package subway.function.station;

import java.util.Scanner;
import subway.commonprint.CommonPrinter;
import subway.main.UserSelections;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationManagement {
    public static void start(Scanner scanner) {
        printScreen();
        StationManagementSelectionType type = getStationManagementSelectionType(scanner);
        resolveStationManagement(type, scanner);
    }

    private static StationManagementSelectionType getStationManagementSelectionType(
        Scanner scanner) {
        CommonPrinter.printUserFunctionSelectionMessage();
        String stationManagementSelectionInput = scanner.nextLine();
        if (stationManagementSelectionInput.equals(UserSelections.FIRST)) {
            return StationManagementSelectionType.STATION_REGISTRATION;
        }
        if (stationManagementSelectionInput.equals(UserSelections.SECOND)) {
            return StationManagementSelectionType.STATION_DELETE;
        }
        if (stationManagementSelectionInput.equals(UserSelections.THIRD)) {
            return StationManagementSelectionType.STATION_PRINT_ALL;
        }
        return StationManagementSelectionType.GO_BACK;
    }

    private static void resolveStationManagement(StationManagementSelectionType type, Scanner scanner) {
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
        StationPrinter.printUserInputStationToDeleteMessage();
        String stationName = scanner.nextLine();
        StationRepository.deleteStation(stationName);
        StationPrinter.printDeleteStationSuccessMessage();
    }

    private static void registerNewStation(Scanner scanner) {
        StationPrinter.printUserInputStationRegistrationMessage();
        String newStationName = scanner.nextLine();
        StationRepository.addStation(new Station(newStationName));
        StationPrinter.printRegisterNewStationSuccessMessage();
    }

    private static void printScreen() {
        PrintStationManagementScreen.printStationManagementScreen();
    }
}
