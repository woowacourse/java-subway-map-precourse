package subway.view;

import java.util.Scanner;

public class InputView {
    public static String inputFunctionNumber(Scanner scanner) {
        System.out.println("## 원하는 기능을 선택하세요.");
        String input = scanner.nextLine();
        printEmptyLine();
        return input;
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}
