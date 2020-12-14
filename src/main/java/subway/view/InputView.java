package subway.view;

import java.util.Scanner;

public class InputView {
    private static final String SELECT_MESSAGE = "## 원하는 기능을 선택하세요.";

    private InputView() {
    }

    public static void getUserSelection(Scanner scanner) {
        System.out.println(SELECT_MESSAGE);
        String userInput = scanner.next();
    }

}
