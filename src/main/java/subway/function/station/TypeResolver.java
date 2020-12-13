package subway.function.station;

import java.util.Scanner;
import subway.common.ResolveResultType;
import subway.main.UserSelections;

public class TypeResolver {

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

    public static ResolveResultType resolveStationManagement(StationManagementSelectionType type,
        Scanner scanner) {
        if (type == StationManagementSelectionType.STATION_REGISTRATION) {
            return StationManagement.registerNewStation(scanner);
        }
        if (type == StationManagementSelectionType.STATION_DELETE) {
            return StationManagement.deleteStation(scanner);
        }
        if (type == StationManagementSelectionType.STATION_PRINT_ALL) {
            return StationManagement.printAllStations();
        }
        return ResolveResultType.ERROR;
    }
}
