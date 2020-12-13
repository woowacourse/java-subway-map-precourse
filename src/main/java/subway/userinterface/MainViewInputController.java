package subway.userinterface;

import subway.util.InputValidator;

import java.util.Scanner;

public class MainViewInputController {
    private final static String MAIN_INPUT = "\n## 원하는 기능을 선택하세요.";
    private static String mainInput;

    public static void getMainMenuInput(Scanner scanner) {

        System.out.println(MAIN_INPUT);
        mainInput = scanner.nextLine();
        validateInput(scanner);

    }

    private static void validateInput(Scanner scanner) {

        try {
            InputValidator.validateMainMenuInput(mainInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getMainMenuInput(scanner);
        }

    }
}
