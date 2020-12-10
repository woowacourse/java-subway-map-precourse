package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
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
    private static final int MINIMUM_LEGNTH = 2;
    private static final String INVALID = "INVALID";

    public static void start() {
        List<String> authorizedCommands = new ArrayList<>(Arrays.asList(ADD_LINE, DELETE_LINE, VIEW_LINES, BACK));
        while (true) {
            String command = UserConsole.getLineManagerCommand(authorizedCommands);
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

    private static void printLines() {
        if (LineRepository.isEmpty()) {
            System.out.println("[ERROR] 노선 목록이 비어있다.");
            return;
        }
        System.out.println("## 노선 목록");
        List<String> lineNames = LineRepository.lines().stream().map(Line::getName).collect(Collectors.toList());
        lineNames.forEach(x -> System.out.println("[INFO] " + x));
    }

    private static void deleteLine() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        String lineName = UserConsole.getInput(); // temporary fix
        if (!isInLineRepository(lineName)) {
            System.out.println("\n[ERROR] 노선이 존재하지 않는다.");
            return;
        }
        LineRepository.deleteLineByName(lineName);
        System.out.println("\n[INFO] 지하철 노선이 삭제되었습니다.");
    }

    private static void addLine() {
        System.out.println("## 등록할 노선 이름을 입력하세요.");

        String lineName = UserConsole.getInput(); // temporary fix
        if (!isLongEnough(lineName)) {
            System.out.println("\n[ERROR] 노선 이름은 2글자 이상이여야 한다.");
            return;
        }
        if (isInLineRepository(lineName)) {
            System.out.println("\n[ERROR] 이미 등록되어 있는 이름이다.");
            return;
        }

        System.out.println("\n## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        String upperTerminalName = UserConsole.getInput(); // temporary fix

        if (!isInStationRepository(upperTerminalName)) {
            System.out.println("\n[ERROR] 등록되어 있지 않은 역이다.");
            return;
        }

        System.out.println("\n## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        String lowerTerminalName = UserConsole.getInput(); // temporary fix

        if (lowerTerminalName.equals(upperTerminalName)) {
            System.out.println("\n[ERROR] 하행 종점역은 상행 종점역과 같으면 안된다.");
            return;
        }

        if (!isInStationRepository(lowerTerminalName)) {
            System.out.println("\n[ERROR] 등록되어 있지 않은 역이다.");
            return;
        }

        Line line = new Line(lineName);
        line.addStation(new Station(upperTerminalName));
        line.addStation(new Station(lowerTerminalName));

        LineRepository.addLine(line);
        System.out.println("\n[INFO] 지하철 노선이 등록되었습니다.");
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

    private static boolean isLongEnough(String lineName) {
        return lineName.length() >= MINIMUM_LEGNTH;
    }
}
