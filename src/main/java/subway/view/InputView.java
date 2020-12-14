package subway.view;

import java.util.Scanner;

public class InputView {
    private static final String CHOOSE_CATEGORY = "## 원하는 기능을 선택하세요.";
    private static final String USER_INPUT_REGEX_START = "[1-";
    private static final String USER_INPUT_REGEX_END = "]";
    private static final String QUIT = "Q";
    private static final String BACK = "B";

    static Scanner scanner = new Scanner(System.in);

    public static String getUserInput() {
        return scanner.nextLine();
    }

    public static String createUserCategorySelection(int endInclusive) {
        boolean isValidInput = false;
        while (!isValidInput) {
            System.out.println(CHOOSE_CATEGORY);
            try {
                return validateCategorySelection(getUserInput(), endInclusive);
            } catch (IllegalArgumentException e) {
                System.err.println(e);
                isValidInput = false;
            }
        }
        return null;
    }

    public static String validateCategorySelection(String userInput, int endInclusive) {
        userInput = userInput.toUpperCase();

        if (!(userInput.matches(USER_INPUT_REGEX_START +
                endInclusive + USER_INPUT_REGEX_END)
                || userInput.equals(BACK) || userInput.equals(QUIT))) {
            throw new IllegalArgumentException();
        }
        return userInput;
    }
}
