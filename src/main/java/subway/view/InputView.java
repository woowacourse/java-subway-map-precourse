package subway.view;

import java.util.Scanner;

public class InputView {
    private static final String SELECT_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String CANNOT_SELECT_MESSAGE = "[ERROR] 선택할 수 없는 기능입니다.";
    private static final char ONE = '1';
    private static final char THREE = '3';
    private static final char FOUR = '4';
    private static final char QUIT = 'Q';

    private InputView() {
    }

    public static void getMainScreenUserSelection(Scanner scanner) {
        System.out.println(SELECT_MESSAGE);
        String userInput = scanner.nextLine();
        try {
            validateUserInput(userInput);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            getMainScreenUserSelection(scanner);
        }
    }

    private static void validateUserInput(String userInput) {
        validateUserInputLength(userInput);
        char characterizedUserInput = userInput.charAt(0);
        if (!isUserInputQuit(characterizedUserInput)) {
            validateUserInputRange(characterizedUserInput);
        }
    }

    private static void validateUserInputLength(String userInput) {
        if (userInput.length() != 1) {
            throw new IllegalArgumentException(CANNOT_SELECT_MESSAGE);
        }
    }

    private static boolean isUserInputQuit(char userInput) {
        return Character.toUpperCase(userInput) == QUIT;
    }

    private static void validateUserInputRange(char userInput) {
        if ((userInput < ONE || userInput > FOUR)) {
            throw new IllegalArgumentException(CANNOT_SELECT_MESSAGE);
        }
    }
}
