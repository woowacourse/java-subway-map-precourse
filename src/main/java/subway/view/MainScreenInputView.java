package subway.view;

import subway.type.MainScreenFunctionType;

import java.util.Scanner;

public class MainScreenInputView {
    private static final String SELECT_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String CANNOT_SELECT_MESSAGE = "[ERROR] 선택할 수 없는 기능입니다.";
    private static final char ONE = '1';
    private static final int INTEGER_ONE = 1;
    private static final char FOUR = '4';
    private static final char QUIT = 'Q';
    private static final int FIRST_CHARACTER = 0;

    private MainScreenInputView() {
    }

    public static boolean getMainScreenUserSelection(Scanner scanner) {
        MainScreenOutputView.printMainScreen();
        System.out.println(SELECT_MESSAGE);
        String userInput = scanner.nextLine();
        try {
            validateUserInput(userInput);
            if (isUserInputQuit(userInput.charAt(FIRST_CHARACTER))) {
                return false;
            }
            executeFunction(userInput);
        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
            getMainScreenUserSelection(scanner);
        }
        return true;
    }

    private static void executeFunction(String userInput) {
        for (MainScreenFunctionType mainScreenFunctionType : MainScreenFunctionType.values()) {
            if (mainScreenFunctionType.isSameFunctionCode(Integer.parseInt(userInput))) {
                mainScreenFunctionType.execute();
            }
        }
    }

    private static void validateUserInput(String userInput) {
        validateUserInputLength(userInput);
        char characterizedUserInput = userInput.charAt(FIRST_CHARACTER);
        if (!isUserInputQuit(characterizedUserInput)) {
            validateUserInputRange(characterizedUserInput);
        }
    }

    private static void validateUserInputLength(String userInput) {
        if (userInput.length() != INTEGER_ONE) {
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
