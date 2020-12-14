package subway.main.type;

import java.util.Scanner;
import subway.function.line.LineManagementMain;
import subway.function.printsubwaymap.PrintSubwayMap;
import subway.function.section.SectionManagementMain;
import subway.function.station.StationManagementMain;

public class MainTypeResolver {
    public static MainSelectionType getMainUserSelectionType(String userInput) {
        if (userInput.equals(UserSelections.FIRST)) {
            return MainSelectionType.STATION_MANAGEMENT;
        }
        if (userInput.equals(UserSelections.SECOND)) {
            return MainSelectionType.LINE_MANAGEMENT;
        }
        if (userInput.equals(UserSelections.THIRD)) {
            return MainSelectionType.SECTION_MANAGEMENT;
        }
        if (userInput.equals(UserSelections.FOURTH)) {
            return MainSelectionType.PRINT_SUBWAY_MAP;
        }
        return MainSelectionType.QUIT;
    }

    public static void resolveUserSelection(MainSelectionType type, Scanner scanner) {
        if (type == MainSelectionType.STATION_MANAGEMENT) {
            StationManagementMain.start(scanner);
        }
        if (type == MainSelectionType.LINE_MANAGEMENT) {
            LineManagementMain.start(scanner);
        }
        if (type == MainSelectionType.SECTION_MANAGEMENT) {
            SectionManagementMain.start(scanner);
        }
        if (type == MainSelectionType.PRINT_SUBWAY_MAP) {
            PrintSubwayMap.start();
        }
    }
}
