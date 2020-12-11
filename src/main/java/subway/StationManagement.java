package subway;

import java.util.Scanner;
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
        Printer.printUserFunctionSelectionMessage();
        String stationManagementSelectionInput = scanner.nextLine();
        if (stationManagementSelectionInput.equals(UserSelections.FIRST)) {
            return StationManagementSelectionType.STATION_REGISTRATION;
        }
        if (stationManagementSelectionInput.equals(UserSelections.SECOND)) {
            return StationManagementSelectionType.STATION_DELETE;
        }
        if (stationManagementSelectionInput.equals(UserSelections.THIRD)) {
            return StationManagementSelectionType.STATION_PRINT;
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
    }

    private static void deleteStation(Scanner scanner) {
        Printer.printUserInputStationToDeleteMessage();
        String stationName = scanner.nextLine();
        StationRepository.deleteStation(stationName);
        Printer.printDeleteStationSuccessMessage();
    }

    private static void registerNewStation(Scanner scanner) {
        Printer.printUserInputStationRegistrationMessage();
        String newStationName = scanner.nextLine();
        StationRepository.addStation(new Station(newStationName));
        Printer.printRegisterNewStationSuccessMessage();
    }

    private static void printScreen() {
        PrintStationManagementScreen.printStationManagementScreen();
    }
}
