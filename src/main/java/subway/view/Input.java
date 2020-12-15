package subway.view;

import java.util.Scanner;

public class Input {
    private static Scanner scanner;

    public static final String CHOOSE_FUNCTION = "## 원하는 기능을 선택하세요.";
    public static final String PLEASE_INPUT_STATION_NAME = "## 등록할 역 이름을 입력하세요.";
    public static final String PLEASE_INPUT_REMOVE_STATION_NAME = "## 삭제할 역 이름을 입력하세요.";
    public static final String PLEASE_INPUT_LINE_NAME = "## 등록할 노선 이름을 입력하세요.";
    public static final String PLEASE_INPUT_UPWARD_TERMINAL_STATION_NAME = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String PLEASE_INPUT_DOWN_TERMINAL_STATION_NAME = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    public static final String PLEASE_INPUT_REMOVE_LINE_NAME = "## 삭제할 노션 이름을 입력하세요.";

    private Input() {
    }

    public static void init(Scanner scanner) {
        if (Input.scanner == null) {
            Input.scanner = scanner;
        }
    }

    public static String input(String message) {
        Output.printNewLine();
        System.out.println(message);
        return Input.scanner.nextLine();
    }
}
