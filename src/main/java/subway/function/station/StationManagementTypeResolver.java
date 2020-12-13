package subway.function.station;

import java.util.Scanner;
import subway.main.UserSelections;

public class StationManagementTypeResolver {

    public static StationManagementSelectionType getStationManagementSelectionType(
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

    public static void resolveStationManagement(StationManagementSelectionType type,
        Scanner scanner) {
        try {
            if (type == StationManagementSelectionType.STATION_REGISTRATION) {
                StationManagement.registerNewStation(scanner);
            }
            if (type == StationManagementSelectionType.STATION_DELETE) {
                StationManagement.deleteStation(scanner);
            }
            if (type == StationManagementSelectionType.STATION_PRINT_ALL) {
                StationManagement.printAllStations();
            }
        } catch (IllegalArgumentException ignored) {
        }
    }
}
