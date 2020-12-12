package subway.manager;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.LogicChecker;
import subway.utils.UserConsole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StationManager {
    private static final String ADD_STATION = "1";
    private static final String DELETE_STATION = "2";
    private static final String VIEW_STATIONS = "3";
    private static final String BACK = "B";
    private static final String STATION_MANAGER = "STATION MANAGER";

    public static void initializeStationManager() {
        List<String> authorizedCommands = new ArrayList<>(Arrays.asList(ADD_STATION, DELETE_STATION, VIEW_STATIONS, BACK));
        startStationManager(authorizedCommands);
    }

    private static void startStationManager(List<String> authorizedCommands) {
        while (true) {
            try {
                String command = UserConsole.getCommand(STATION_MANAGER, authorizedCommands);
                if (command.equals(BACK)) {
                    break;
                }
                execute(command);
            } catch (Exception exception) {
                continue;
            }
        }
    }

    private static void execute(String command) throws IllegalArgumentException {
        if (command.equals(ADD_STATION)) {
            addStation();
        }
        if (command.equals(DELETE_STATION)) {
            deleteStation();
        }
        if (command.equals(VIEW_STATIONS)) {
            printStations();
        }
    }

    private static void printStations() throws IllegalArgumentException {
        LogicChecker.checkIfStationRepositoryIsNotEmpty();
        System.out.println("## 역 목록");
        StationRepository.stations().forEach(station -> System.out.println("[INFO] " + station.getName()));
        System.out.println();
    }

    private static void deleteStation() throws IllegalArgumentException {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        String stationName = UserConsole.getName();
        LogicChecker.checkIfStationRepositoryContainsStation(stationName);
        LogicChecker.checkIfStationIsNotInLines(stationName);
        StationRepository.deleteStation(stationName);
        System.out.println("[INFO] 지하철 역이 삭제되었습니다.\n");
    }

    private static void addStation() throws IllegalArgumentException {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        String stationName = UserConsole.getName();
        LogicChecker.checkIfStationIsNotInStationRepository(stationName);
        StationRepository.addStation(new Station(stationName));
        System.out.println("[INFO] 지하철 역이 등록되었습니다.\n");
    }
}
