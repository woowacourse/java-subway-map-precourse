package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StationManager {
    private static final String ADD_STATION = "1";
    private static final String DELETE_STATION = "2";
    private static final String VIEW_STATIONS = "3";
    private static final String BACK = "B";
    private static final String INVALID = "INVALID";

    public static void start() {
        List<String> authorizedCommands = new ArrayList<>(Arrays.asList(ADD_STATION, DELETE_STATION, VIEW_STATIONS, BACK));
        while (true) {
            String command = UserConsole.getStationManagerCommand(authorizedCommands);
            if (command.equals(INVALID)) {
                continue;
            }
            if (command.equals(BACK)) {
                break;
            }
            execute(command);
        }
    }

    private static void execute(String command) {
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

    private static void printStations() {
        if (StationRepository.isEmpty()) {
            System.out.println("[ERROR] 역 목록이 비어있다.\n");
            return;
        }
        System.out.println("## 역 목록");
        StationRepository.stations().forEach(station -> System.out.println("[INFO] " + station.getName()));
        System.out.println();
    }

    private static void deleteStation() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        String stationName = UserConsole.getInput(); // temporary fix
        if (!StationRepository.contains(stationName)) {
            System.out.println("[ERROR] 역이 존재하지 않는다.\n");
            return;
        }
        if (isInLines(stationName)) {
            System.out.println("[ERROR] 노선에 등록되어 있는 역은 지울 수 없다.\n");
            return;
        }
        StationRepository.deleteStation(stationName);
        System.out.println("[INFO] 지하철 역이 삭제되었습니다.\n");
    }

    private static boolean isInLines(String stationName) {
        List<Line> lines = LineRepository.lines();
        return lines.stream().anyMatch(line -> line.contains(stationName));
    }

    private static void addStation() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        String stationName = UserConsole.getInput(); // temporary fix
        if (!Validator.isAppropriateLength(stationName)) {
            return;
        }
        if (StationRepository.contains(stationName)) {
            System.out.println("[ERROR] 이미 등록되어 있는 이름이다.\n");
            return;
        }
        StationRepository.addStation(new Station(stationName));
        System.out.println("[INFO] 지하철 역이 등록되었습니다.\n");
    }
}
