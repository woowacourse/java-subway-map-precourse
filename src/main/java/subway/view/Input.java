package subway.view;

import java.util.Scanner;

public class Input {
    private static final String CHOOSE_FUNCTION_MESSAGE = "## 원하는 기능을 선택하세요.";

    public static String choose(Scanner scanner) {
        System.out.println(CHOOSE_FUNCTION_MESSAGE);
        return scanner.nextLine();
    }
}
