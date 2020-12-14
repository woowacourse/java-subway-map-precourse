package subway.view;

import subway.Constants;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static String getUserInput() {
        return scanner.nextLine();
    }

    public static String createUserCategorySelection(int endInclusive) {
        boolean isValidInput = false;
        while (!isValidInput) {
            System.out.println("## 원하는 기능을 선택하세요.");
            try {
                return validateCategorySelection(getUserInput(), endInclusive);
            } catch (IllegalArgumentException e) {
                System.err.println("[ERROR] 선택할 수 없는 기능입니다.");
                isValidInput = false;
            }
        }
        return null;
    }

    public static String validateCategorySelection(String userInput, int endInclusive) {
        userInput = userInput.toUpperCase();

        if (!(userInput.matches(Constants.USER_INPUT_REGEX_START +
                endInclusive + Constants.USER_INPUT_REGEX_END)
                || userInput.equals(Constants.BACK) || userInput.equals(Constants.QUIT))) {
            throw new IllegalArgumentException();
        }
        return userInput;
    }
}
