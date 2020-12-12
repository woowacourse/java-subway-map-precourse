package subway.manager;

import subway.utils.UserConsole;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LineManager {
    private static final String ADD_LINE = "1";
    private static final String DELETE_LINE = "2";
    private static final String VIEW_LINES = "3";
    private static final String BACK = "B";
    private static final String LINE_MANAGER = "LINE MANAGER";

    public static void initializeLineManager() {
        List<String> authorizedCommands = new ArrayList<>(Arrays.asList(ADD_LINE, DELETE_LINE, VIEW_LINES, BACK));
        startLineManager(authorizedCommands);
    }

    private static void startLineManager(List<String> authorizedCommands) {
        while (true) {
            try {
                String command = UserConsole.getCommand(LINE_MANAGER, authorizedCommands);
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
        if (command.equals(ADD_LINE)) {
            addLine();
        }
        if (command.equals(DELETE_LINE)) {
            deleteLine();
        }
        if (command.equals(VIEW_LINES)) {
            printLines();
        }
    }

    private static void printLines() throws IllegalArgumentException {
        if (LineRepository.isEmpty()) {
            System.out.println("[ERROR] 노선 목록이 비어있다.\n");
            throw new IllegalArgumentException();
        }
        System.out.println("## 노선 목록");
        LineRepository.lines().forEach(line -> System.out.println("[INFO] " + line.getName()));
        System.out.println();
    }

    private static void deleteLine() throws IllegalArgumentException {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        String lineName = UserConsole.getName();
        if (!LineRepository.contains(lineName)) {
            System.out.println("[ERROR] 노선이 존재하지 않는다.\n");
            throw new IllegalArgumentException();
        }
        LineRepository.deleteLineByName(lineName);
        System.out.println("[INFO] 지하철 노선이 삭제되었습니다.\n");
    }

    private static void addLine() throws IllegalArgumentException {
        Line line = getNewLine();
        String firstTerminalStationName = getFirstTerminalStationName();
        String secondTerminalStationName = getSecondStationName(firstTerminalStationName);
        LineRepository.addLineWithStationNames(line, Arrays.asList(firstTerminalStationName, secondTerminalStationName));
        System.out.println("[INFO] 지하철 노선이 등록되었습니다.\n");
    }

    private static String getSecondStationName(String firstTerminalStationName) throws IllegalArgumentException {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        String stationName = UserConsole.getName();
        if (firstTerminalStationName.equals(stationName)) {
            System.out.println("[ERROR] 하행 종점역은 상행 종점역과 같으면 안된다.\n");
            throw new IllegalArgumentException();
        }
        if (!StationRepository.contains(stationName)) {
            System.out.println("[ERROR] 등록되어 있지 않은 역이다.\n");
            throw new IllegalArgumentException();
        }
        return stationName;
    }

    private static String getFirstTerminalStationName() throws IllegalArgumentException {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        String stationlName = UserConsole.getName();
        if (!StationRepository.contains(stationlName)) {
            System.out.println("[ERROR] 등록되어 있지 않은 역이다.\n");
            throw new IllegalArgumentException();
        }
        return stationlName;
    }

    private static Line getNewLine() throws IllegalArgumentException {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
        String lineName = UserConsole.getName();
        if (LineRepository.contains(lineName)) {
            System.out.println("[ERROR] 이미 등록되어 있는 이름이다.\n");
            throw new IllegalArgumentException();
        }
        return new Line(lineName);
    }
}
