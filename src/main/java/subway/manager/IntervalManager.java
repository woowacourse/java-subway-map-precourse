package subway.manager;

import subway.utils.LogicChecker;
import subway.utils.UserConsole;
import subway.domain.LineRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalManager {
    private static final String ADD_INTERVAL = "1";
    private static final String DELETE_INTERVAL = "2";
    private static final String BACK = "B";
    private static final String INTERVAL_MANAGER = "INTERVAL MANAGER";

    public static void initializeIntervalManager() {
        List<String> authorizedCommands = new ArrayList<>(Arrays.asList(ADD_INTERVAL, DELETE_INTERVAL, BACK));
        while (true) {
            String result = startIntervalManager(authorizedCommands);
            if (!result.equals(INTERVAL_MANAGER)) {
                break;
            }
        }
    }

    private static String startIntervalManager(List<String> authorizedCommands) {
        String command = UserConsole.getCommand(INTERVAL_MANAGER, authorizedCommands);
        if (command.equals(BACK)) {
            return command;
        }
        try {
            execute(command);
        } catch (Exception exception) {
            command = INTERVAL_MANAGER;
        }
        return command;
    }

    private static void execute(String command) throws IllegalArgumentException {
        if (command.equals(ADD_INTERVAL)) {
            addInterval();
        }
        if (command.equals(DELETE_INTERVAL)) {
            deleteInterval();
        }
    }

    private static void deleteInterval() throws IllegalArgumentException {
        String lineName = getLineNameForIntervalDelete();
        String stationName = getStationNameForIntervalDelete(lineName);
        LineRepository.updateLineByDeletingStation(lineName, stationName);
        System.out.println("[INFO] 구간이 삭제되었습니다.\n");
    }

    private static String getStationNameForIntervalDelete(String lineName) throws IllegalArgumentException {
        System.out.println("## 삭제할 구간의 역을 입력하세요.");
        String stationName = UserConsole.getName();
        LogicChecker.checkIfStationRepositoryContainsStation(stationName);
        LogicChecker.checkIfLineContainsStation(lineName, stationName);
        return stationName;
    }

    private static String getLineNameForIntervalDelete() throws IllegalArgumentException {
        System.out.println("## 삭제할 구간의 노선을 입력하세요.");
        String lineName = UserConsole.getName();
        LogicChecker.checkIfLineRepositoryContainsLine(lineName);
        LogicChecker.checkIfLineIsAboveDeleteLimit(lineName);
        return lineName;
    }

    private static void addInterval() throws IllegalArgumentException {
        String lineName = getLineNameForIntervalAdd();
        String stationName = getStationNameForIntervalAdd();
        LogicChecker.checkIfLineDoesNotContainStation(lineName, stationName);
        int index = getIndex(lineName);
        LineRepository.updateLineByAddingStation(lineName, stationName, index);
        System.out.println("[INFO] 구간이 등록되었습니다.\n");
    }

    private static int getIndex(String lineName) throws IllegalArgumentException {
        System.out.println("## 순서를 입력하세요.");
        int index = UserConsole.getNaturalNumber();
        LogicChecker.checkIfLineHasCapacityForIndex(index, lineName);
        return index;
    }

    private static String getStationNameForIntervalAdd() throws IllegalArgumentException {
        System.out.println("## 역이름을 입력하세요.");
        String stationName = UserConsole.getName();
        LogicChecker.checkIfStationRepositoryContainsStation(stationName);
        return stationName;
    }

    private static String getLineNameForIntervalAdd() throws IllegalArgumentException {
        System.out.println("## 노선을 입력하세요.");
        String lineName = UserConsole.getName();
        LogicChecker.checkIfLineRepositoryContainsLine(lineName);
        return lineName;
    }
}
