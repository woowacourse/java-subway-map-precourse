package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StationManager {
    private static final String ADD_STATION = "1";
    private static final String DELETE_STATION = "2";
    private static final String VIEW_STATIONS = "3";
    private static final String BACK = "B";
    private static final int MINIMUM_LEGNTH = 2;
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
            System.out.println("[ERROR] 역 목록이 비어있다.");
            return;
        }
        System.out.println("## 역 목록");
        List<String> stationNames = StationRepository.stations().stream().map(Station::getName).collect(Collectors.toList());
        stationNames.forEach(x -> System.out.println("[INFO] " + x));
    }

    private static void deleteStation() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        String stationName = UserConsole.getInput(); // temporary fix
        if (!isInStationRepository(stationName)) {
            System.out.println("\n[ERROR] 역이 존재하지 않는다.");
            return;
        }
        if (isInLines(stationName)) {
            System.out.println("\n[ERROR] 노선에 등록되어 있는 역은 지울 수 없다.");
            return;
        }
        StationRepository.deleteStation(stationName);
        System.out.println("\n[INFO] 지하철 역이 삭제되었습니다.");
    }

    private static boolean isInLines(String stationName) {
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            if (line.hasStation(stationName)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isInStationRepository(String stationName) {
        List<String> stationNames = StationRepository.stations().stream().map(Station::getName).collect(Collectors.toList());
        if (stationNames.contains(stationName)) {
            return true;
        }
        return false;
    }

    private static void addStation() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        String stationName = UserConsole.getInput(); // temporary fix
        if (!isLongEnough(stationName)) {
            System.out.println("\n[ERROR] 역 이름은 2글자 이상이여야 한다.");
            return;
        }
        if (isInStationRepository(stationName)) {
            System.out.println("\n[ERROR] 이미 등록되어 있는 이름이다.");
            return;
        }
        StationRepository.addStation(new Station(stationName));
        System.out.println("\n[INFO] 지하철 역이 등록되었습니다.");
    }

    private static boolean isLongEnough(String stationName) {
        return stationName.length() >= MINIMUM_LEGNTH;
    }
}
