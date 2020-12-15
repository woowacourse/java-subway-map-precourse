package view.io;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.sql.rowset.serial.SQLInputImpl;

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

    private static HashMap<String, String> saveNewInfo(HashMap<String, String> info, String inputMessage, String key) {
        System.out.println(inputMessage);
        info.put(key, scanner.next());
        System.out.println();
        return info;
    }

    public static HashMap<String, String> inputNewLineInfo() {
        HashMap<String, String> info = new HashMap<>(Map.of());

        saveNewInfo(info, NEW_LINE_NAME, "lineName");
        saveNewInfo(info, START_TERMINAL_NAME, "startTerminalName");
        saveNewInfo(info, END_TERMINAL_NAME, "endTerminalName");

        return info;
    }

    private static String inputName(String inputMessage) {
        System.out.println(inputMessage);
        String name = scanner.next();
        System.out.println();
        return name;
    }

    public static String inputDeleteLineName() {
        return inputName(DELETE_LINE_NAME);
    }

    public static String inputLineName() {
        return inputName(INPUT_LINE_NAME);
    }

    public static String inputStationName() {
        return inputName(INPUT_STATION_NAME);
    }

    public static String inputNewStationName() {
        return inputName(INPUT_NEW_STATION_NAME);
    }

    public static String inputDeleteStationName() {
        return inputName(DELETE_STATION_NAME);
    }

    public static int inputOrder() {
        System.out.println(INPUT_ORDER);
        int order = scanner.nextInt();
        return order;
    }

    public static String[] inputDeleteIntervalInfo() {
        String[] info = new String[2];
        info[0] = inputName(DELETE_LINE_OF_INTERVAL);
        info[1] = inputName(DELETE_STATION_OF_INTERVAL);
        return info;
    }
}
