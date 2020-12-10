package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalManager {
    private static final String ADD_INTERVAL = "1";
    private static final String DELETE_INTERVAL = "2";
    private static final String BACK = "B";
    private static final String INVALID = "INVALID";

    public static void start() {
        List<String> authorizedCommands = new ArrayList<>(Arrays.asList(ADD_INTERVAL, DELETE_INTERVAL, BACK));
        while (true) {
            String command = UserConsole.getIntervalManagerCommand(authorizedCommands);
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
        if (command.equals(ADD_INTERVAL)) {
            addInterval();
        }
        if (command.equals(DELETE_INTERVAL)) {
            deleteInterval();
        }
    }

    private static void deleteInterval() {
        System.out.println("## 삭제할 구간의 노선을 입력하세요.");
        String lineName = UserConsole.getInput(); // temporary fix
        if (!isInLineRepository(lineName)) {
            System.out.println("\n[ERROR] 노선이 존재하지 않는다.");
            return;
        }
        System.out.println("\n## 삭제할 구간의 역을 입력하세요.");
        String stationName = UserConsole.getInput(); // temporary fix
        if (!isInStationRepository(stationName)) {
            System.out.println("\n[ERROR] 등록되어 있지 않은 역이다.");
            return;
        }
        Line line = LineRepository.getLineByName(lineName);
        if (!line.isStationDeletable()) {
            System.out.println("\n[ERROR] 노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없다.");
            return;
        }
        line.deleteStation(stationName);
        System.out.println("\n[INFO] 구간이 삭제되었습니다.");
    }

    private static void addInterval() {
        System.out.println("## 노선을 입력하세요.");
        String targetLineName = UserConsole.getInput(); // temporary fix

        if (!isInLineRepository(targetLineName)) {
            System.out.println("\n[ERROR] 노선이 존재하지 않는다.");
            return;
        }

        System.out.println("\n## 역이름을 입력하세요.");
        String stationName = UserConsole.getInput(); // temporary fix

        if (!isInStationRepository(stationName)) {
            System.out.println("\n[ERROR] 등록되어 있지 않은 역이다.");
            return;
        }

        if (isInTargetLine(stationName, targetLineName)) {
            System.out.println("\n[ERROR] 노선에 등록되어 있는 역은 추가할 수 없다.");
            return;
        }

        System.out.println("\n## 순서를 입력하세요.");
        String order = UserConsole.getInput(); // temporary fix
        if (!isNaturalNumber(order)) {
            System.out.println("\n[ERROR] 순서는 자연수이어야 한다");
            return;
        }
        if (!isAppropriateOrder(order, targetLineName)) {
            System.out.println("\n[ERROR] 올바르지 않은 순서이다.");
            return;
        }

        Line targetLine = LineRepository.getLineByName(targetLineName);
        targetLine.addStation(Integer.parseInt(order) - 1, StationRepository.getStationbyName(stationName));
        System.out.println("\n[INFO] 구간이 등록되었습니다.");
    }

    private static boolean isAppropriateOrder(String order, String targetLineName) {
        Line targetLine = LineRepository.getLineByName(targetLineName);
        if (targetLine.hasCapacitiy(Integer.parseInt(order))) {
            return true;
        }
        return false;
    }

    private static boolean isNaturalNumber(String order) {
        if (!isAllDigit(order)) {
            return false;
        }
        if (isFirstDigitZero(order)) {
            return false;
        }
        return true;
    }

    private static boolean isFirstDigitZero(String order) {
        if (!order.isEmpty() && order.charAt(0) == '0') {
            return true;
        }
        return false;
    }

    private static boolean isAllDigit(String order) {
        for (char temp : order.toCharArray()) {
            if ('0' <= temp && temp <= '9') {
                continue;
            }
            return false;
        }
        return true;
    }

    private static boolean isInTargetLine(String stationName, String targetLineName) {
        Line targetLine = LineRepository.getLineByName(targetLineName);
        if (targetLine.hasStation(stationName)) {
            return true;
        }
        return false;
    }

    private static boolean isInStationRepository(String stationName) {
        if (StationRepository.contains(stationName)) {
            return true;
        }
        return false;
    }

    private static boolean isInLineRepository(String stationName) {
        if (LineRepository.contains(stationName)) {
            return true;
        }
        return false;
    }
}
