package subway.manager;

import subway.utils.LogicChecker;
import subway.utils.UserConsole;
import subway.domain.Line;
import subway.domain.LineRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainManager {
    private static final String MAGNAGE_STATION = "1";
    private static final String MAGNAGE_LINE = "2";
    private static final String MAGNAGE_INTERVAL = "3";
    private static final String PRINT_SUBWAY_MAP = "4";
    private static final String EXIT = "Q";
    private static final String MAIN = "MAIN";

    public static void initializeMainManager() {
        List<String> authorizedCommands = new ArrayList<>(Arrays.asList(MAGNAGE_STATION, MAGNAGE_LINE, MAGNAGE_INTERVAL, PRINT_SUBWAY_MAP, EXIT));
        startMainManager(authorizedCommands);
    }

    private static void startMainManager(List<String> authorizedCommands) {
        while (true) {
            try {
                String command = UserConsole.getCommand(MAIN, authorizedCommands);
                if (command.equals(EXIT)) {
                    break;
                }
                execute(command);
            } catch (Exception exception) {
                continue;
            }
        }
    }

    private static void execute(String command) throws IllegalArgumentException {
        if (command.equals(MAGNAGE_STATION)) {
            StationManager.initializeStationManager();
        }
        if (command.equals(MAGNAGE_LINE)) {
            LineManager.initializeLineManager();
        }
        if (command.equals(MAGNAGE_INTERVAL)) {
            IntervalManager.initializeIntervalManager();
        }
        if (command.equals(PRINT_SUBWAY_MAP)) {
            printSubwayMap();
        }
    }

    private static void printSubwayMap() throws IllegalArgumentException {
        LogicChecker.checkIfLineRepositoryIsNotEmpty();
        List<Line> lines = LineRepository.lines();
        System.out.println("## 지하철 노선도");
        for (Line line : lines) {
            printLineWithStations(line);
            System.out.println();
        }
    }

    private static void printLineWithStations(Line line) {
        System.out.println("[INFO] " + line.getName());
        System.out.println("[INRO] ---");
        List<String> stationNames = line.getStationNames();
        stationNames.forEach(stationName -> System.out.println("[INFO] " + stationName));
    }
}
