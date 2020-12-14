package view.io;

import java.util.Map;
import java.util.Scanner;

public class InputView {

    private static final String CHOOSE_FEATURE = "## 원하는 기능을 선택하세요.";
    private static final String NEW_LINE_NAME = "## 등록할 노선 이름을 입력하세요.";
    private static final String DELETE_LINE_NAME = "## 삭제할 노선 이름을 입력하세요.";
    private static final String INPUT_NEW_STATION_NAME = "## 등록할 역 이름을 입력하세요.";
    private static final String DELETE_STATION_NAME = "## 삭제할 역 이름을 입력하세요.";
    private static final String INPUT_ORDER = "## 순서를 입력하세요.";
    private static final String INPUT_LINE_NAME = "## 노선 이름을 입력하세요.";
    private static final String INPUT_STATION_NAME = "## 역 이름을 입력하세요.";
    private static final String DELETE_LINE_OF_INTERVAL = "## 삭제할 구간의 노선을 입력하세요.";
    private static final String DELETE_STATION_OF_INTERVAL = "## 삭제할 구간의 역을 입력하세요.";
    private static final String START_TERMINAL_NAME = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String END_TERMINAL_NAME = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String ONE_LINE = "\n";
    private static final int START = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static char inputChoice() {
        System.out.println(ONE_LINE + CHOOSE_FEATURE);
        char choice = scanner.next().charAt(START);
        System.out.println();
        return choice;
    }

    public static Map<String, String> inputNewLineInfo() {
        Map<String, String> info = Map.of();

        System.out.println(NEW_LINE_NAME);
        info.put("lineName", scanner.next());

        System.out.println(START_TERMINAL_NAME);
        info.put("startTerminalName", scanner.next());

        System.out.println(END_TERMINAL_NAME);
        info.put("endTerminalName", scanner.next());

        return info;
    }

    public static String inputDeleteLineName() {
        System.out.println(DELETE_LINE_NAME);
        String lineName = scanner.next();
        return lineName;
    }


    public static String inputLineName() {
        System.out.println(INPUT_LINE_NAME);
        String lineName = scanner.next();
        return lineName;
    }

    public static String inputNewStationName() {
        System.out.println(INPUT_NEW_STATION_NAME);
        String stationName = scanner.next();
        System.out.println();
        return stationName;
    }

    public static String inputDeleteStationName() {
        System.out.println(DELETE_STATION_NAME);
        String stationName = scanner.next();
        return stationName;
    }

    public static String inputStationName() {
        System.out.println(INPUT_STATION_NAME);
        String stationName = scanner.next();
        return stationName;
    }

    public static int inputOrder() {
        System.out.println(INPUT_ORDER);
        int order = scanner.nextInt();
        return order;
    }

    public static String[] inputDeleteIntervalInfo() {
        String[] info = new String[2];
        System.out.println(DELETE_LINE_OF_INTERVAL);
        info[0] = scanner.next();
        System.out.println(DELETE_STATION_OF_INTERVAL);
        info[1] = scanner.next();
        return info;
    }
}
