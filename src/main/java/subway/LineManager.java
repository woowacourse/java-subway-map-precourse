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

public class LineManager {
    private static final String ADD_LINE = "1";
    private static final String DELETE_LINE = "2";
    private static final String VIEW_LINES = "3";
    private static final String BACK = "B";
    private static final int MINIMUM_LEGNTH = 2;
    private static final String INVALID = "INVALID";

    public static void start(Scanner scanner) {
        while (true) {
            showOption();
            String command = getLineManagerContolCommand(scanner);
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
        if (command.equals(ADD_LINE)) {
            addLine(scanner);
        }
        if (command.equals(DELETE_LINE)) {
            deleteLine(scanner);
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

    private static void deleteLine(Scanner scanner) {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        String lineName = scanner.nextLine();
        if (!isInLineRepository(lineName)) {
            System.out.println("\n[ERROR] 노선이 존재하지 않는다.");
            return;
        }
        LineRepository.deleteLineByName(lineName);
        System.out.println("\n[INFO] 지하철 노선이 삭제되었습니다.");
    }

    private static void addLine(Scanner scanner) {
        System.out.println("## 등록할 노선 이름을 입력하세요.");

        String lineName = scanner.nextLine();
        if (!isLongEnough(lineName)) {
            System.out.println("\n[ERROR] 노선 이름은 2글자 이상이여야 한다.");
            return;
        }
        if (isInLineRepository(lineName)) {
            System.out.println("\n[ERROR] 이미 등록되어 있는 이름이다.");
            return;
        }

        System.out.println("\n## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        String upperTerminalName = scanner.nextLine();

        if (!isInStationRepository(upperTerminalName)) {
            System.out.println("\n[ERROR] 등록되어 있지 않은 역이다.");
            return;
        }

        System.out.println("\n## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        String lowerTerminalName = scanner.nextLine();

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

    private static String getLineManagerContolCommand(Scanner scanner) {
        List<String> commands = new ArrayList<>(Arrays.asList(ADD_LINE, DELETE_LINE, VIEW_LINES, BACK));
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
        System.out.println("\n## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기\n");
    }
}
