package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StationManager {
    private static final String ADD_STATION = "1";
    private static final String DELETE_STATION = "2";
    private static final String VIEW_STATIONS = "3";
    private static final String BACK = "B";
    private static final int MINIMUM_LEGNTH = 2;
    private static final String INVALID = "INVALID";

    public static void start(Scanner scanner) {
        while (true) {
            showOption();
            String command = getStationManagerContolCommand(scanner);
            if (command.equals(INVALID)) {
                continue;
            }
            if (command.equals(BACK)) {
                break;
            }

            execute(command, scanner);
        }
    }

    private static void execute(String command, Scanner scanner) {
        if (command.equals(ADD_STATION)) {
            addStation(scanner);
        }
        if (command.equals(DELETE_STATION)) {
            deleteStation(scanner);
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

    private static void deleteStation(Scanner scanner) {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        String stationName = scanner.nextLine();
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

    private static void addStation(Scanner scanner) {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        String stationName = scanner.nextLine();
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

    private static String getStationManagerContolCommand(Scanner scanner) {
        List<String> commands = new ArrayList<>(Arrays.asList(ADD_STATION, DELETE_STATION, VIEW_STATIONS, BACK));
        System.out.println("## 원하는 기능을 선택하세요.");
        String userInput = scanner.nextLine();
        System.out.println();
        if (commands.contains(userInput)) {
            return userInput;
        }
        System.out.println("[ERROR] 없는 기능입니다.");
        return INVALID;
    }

    private static void showOption() {
        System.out.println("\n## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기\n");
    }
}
