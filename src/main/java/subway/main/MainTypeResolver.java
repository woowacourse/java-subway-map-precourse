package subway.main;

import java.util.Scanner;
import subway.function.line.LineManagement;
import subway.function.printsubwaymap.PrintSubwayMap;
import subway.function.section.SectionManagement;
import subway.function.station.StationManagement;

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
            StationManagement.start(scanner);
        }
        if (type == MainSelectionType.LINE_MANAGEMENT) {
            LineManagement.start(scanner);
        }
        if (type == MainSelectionType.SECTION_MANAGEMENT) {
            SectionManagement.start(scanner);
        }
        if (type == MainSelectionType.PRINT_SUBWAY_MAP) {
            PrintSubwayMap.start();
        }
    }
}
