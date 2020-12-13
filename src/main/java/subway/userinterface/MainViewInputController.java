package subway.userinterface;

import subway.util.InputValidator;

import java.util.Scanner;

public class MainViewInputController {
    private final static String MAIN_INPUT = "## 원하는 기능을 선택하세요.";
    private static String mainInput;

    public static void getMainMenuInput(Scanner scanner) {

        System.out.println(MAIN_INPUT);
        mainInput = scanner.nextLine();
        validateInput();

    }

    private static void validateInput() {
        boolean inputValidity = false;

        while (!inputValidity) {
            try {
                InputValidator.validateMainMenuInput(mainInput);
                inputValidity = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
