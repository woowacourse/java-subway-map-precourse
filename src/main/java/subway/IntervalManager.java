package subway;

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
    private static final int DELETE_LIMIT = 2;

    public static void start() {
        List<String> authorizedCommands = new ArrayList<>(Arrays.asList(ADD_INTERVAL, DELETE_INTERVAL, BACK));
        while (true) {
            try {
                String command = UserConsole.getIntervalManagerCommand(authorizedCommands);
                if (command.equals(BACK)) {
                    break;
                }
                execute(command);
            } catch (Exception exception) {
                continue;
            }
        }
    }

    private static void execute(String command) throws Exception {
        if (command.equals(ADD_INTERVAL)) {
            addInterval();
        }
        if (command.equals(DELETE_INTERVAL)) {
            deleteInterval();
        }
    }

    private static void deleteInterval() throws Exception {
        String lineName = getLineNameForIntervalDelete();
        String stationName = getStationNameForIntervalDelete(lineName);
        LineRepository.deleteStationNameFromLine(lineName, stationName);
        System.out.println("[INFO] 구간이 삭제되었습니다.\n");
    }

    private static String getStationNameForIntervalDelete(String lineName) throws Exception {
        System.out.println("## 삭제할 구간의 역을 입력하세요.");
        String stationName = UserConsole.getName(); // temporary fix
        if (!StationRepository.contains(stationName)) {
            System.out.println("[ERROR] 역 목록에 등록되어 있지 않은 역이다.\n");
            throw new IllegalArgumentException();
        }
        if (!LineRepository.containsLineWithStationName(lineName, stationName)) {
            System.out.println("[ERROR] 노선에 등록되어 있지 않은 역이다.\n");
            throw new IllegalArgumentException();
        }
        return stationName;
    }

    private static String getLineNameForIntervalDelete() throws Exception {
        System.out.println("## 삭제할 구간의 노선을 입력하세요.");
        String lineName = UserConsole.getName(); // temporary fix
        if (!LineRepository.contains(lineName)) {
            System.out.println("[ERROR] 노선이 존재하지 않는다.\n");
            throw new IllegalArgumentException();
        }
        if (!LineRepository.containsLineAboveDeleteLimit(lineName, DELETE_LIMIT)) {
            System.out.println("[ERROR] 노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없다.\n");
            throw new IllegalArgumentException();
        }
        return lineName;
    }

    private static void addInterval() throws Exception {
        String lineName = getLineNameForIntervalAdd();
        String stationName = getStationNameForIntervalAdd();
        if (LineRepository.containsLineWithStationName(lineName, stationName)) {
            System.out.println("[ERROR] 노선에 등록되어 있는 역은 추가할 수 없다.\n");
            return;
        }
        int index = getIndex(lineName);
        LineRepository.addStationNameToLine(lineName, stationName, index);
        System.out.println("[INFO] 구간이 등록되었습니다.\n");
    }

    private static int getIndex(String lineName) {
        System.out.println("## 순서를 입력하세요.");
        int index = UserConsole.getZeroOrNaturalNumber(); // temporary fix
        if (!LineRepository.containsLineForIndex(lineName, index)) {
            System.out.println("[ERROR] 올바르지 않은 순서이다.\n");
            throw new IllegalArgumentException();
        }
        return index;
    }

    private static String getStationNameForIntervalAdd() throws Exception {
        System.out.println("## 역이름을 입력하세요.");
        String stationName = UserConsole.getName(); // temporary fix
        if (!StationRepository.contains(stationName)) {
            System.out.println("[ERROR] 역 목록에 등록되어 있지 않은 역이다.\n");
            throw new IllegalArgumentException();
        }
        return stationName;
    }

    private static String getLineNameForIntervalAdd() throws Exception {
        System.out.println("## 노선을 입력하세요.");
        String lineName = UserConsole.getName(); // temporary fix
        if (!LineRepository.contains(lineName)) {
            System.out.println("[ERROR] 노선이 존재하지 않는다.\n");
            throw new IllegalArgumentException();
        }
        return lineName;
    }
}
