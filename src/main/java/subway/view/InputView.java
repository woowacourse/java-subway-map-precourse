package subway.view;

import subway.domain.Name;

import java.util.Scanner;

public class InputView {
    private InputView() {
    }

    public static int getInteger(Scanner scanner) {
        String input = getInput(scanner);

        if (!isNumeric(input)) {
            throw new IllegalArgumentException("정수 범위의 숫자를 입력하세요.");
        }

        return Integer.parseInt(input);
    }

    private static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Name getName(Scanner scanner) {
        return new Name(getInput(scanner));
    }

    public static String getInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
