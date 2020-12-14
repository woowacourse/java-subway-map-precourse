package subway.view;

import java.util.Scanner;

public class Input {
    private static Scanner scanner;
    public static final String CHOOSE_FUNCTION_MESSAGE = "## 원하는 기능을 선택하세요.";
    public static final String PLEASE_INPUT_STATION_MESSAGE = "## 등록할 역 이름을 입력하세요.";
    public static final String PLEASE_INPUT_REMOVE_STATION_NAME = "## 삭제할 역 이름을 입력하세요.";

    private Input() {
    }

    public static void init(Scanner scanner) {
        if (Input.scanner == null){
            Input.scanner = scanner;
        }
    }

    public static String input( String message) {
        System.out.println(message);
        return Input.scanner.nextLine();
    }
}
