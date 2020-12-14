package subway.function.station.type;

import java.util.Scanner;
import subway.function.station.management.DeleteStation;
import subway.function.station.management.PrintAllStationsList;
import subway.function.station.management.RegisterNewStation;
import subway.main.type.UserSelections;

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
                RegisterNewStation.registerNewStation(scanner);
            }
            if (type == StationManagementSelectionType.STATION_DELETE) {
                DeleteStation.deleteStation(scanner);
            }
            if (type == StationManagementSelectionType.STATION_PRINT_ALL) {
                PrintAllStationsList.printAllStationsList();
            }
        } catch (IllegalArgumentException ignored) {
        }
    }
}
