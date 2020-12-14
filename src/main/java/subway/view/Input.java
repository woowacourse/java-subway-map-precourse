package subway.view;

import java.util.Scanner;

public class Input {
    public static final String CHOOSE_FUNCTION_MESSAGE = "## 원하는 기능을 선택하세요.";
    public static final String PLEASE_INPUT_STATION_MESSAGE = "## 등록할 역 이름을 입력하세요.";

    private Input() {
    }

    public static String input(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
