package subway.view;

import subway.Constants;
import subway.Load;

import java.util.Scanner;

public class UserInputNumberSelection {
    static Scanner scanner = new Scanner(System.in);

    public static String getUserInput() {
        return scanner.nextLine();
    }

    public static String createUserSelectionInput(int endInclusive) {
        boolean isValidInput = false;
        while (!isValidInput) {
            System.out.println("## 원하는 기능을 선택하세요.");
            try {
                return validateUserSelectionInput(getUserInput(), endInclusive);
            } catch (IllegalArgumentException e) {
                System.err.println("[ERROR] 선택할 수 없는 기능입니다.");
                isValidInput = false;
            }
        }
        return null;
    }

    public static String validateUserSelectionInput(String userInput, int endInclusive) {
        userInput = userInput.toUpperCase();

        if (!(userInput.matches( Constants.USER_INPUT_REGEX_START +
                endInclusive + Constants.USER_INPUT_REGEX_END))
                || userInput.equals("B") || userInput.equals("Q")) {
            throw new IllegalArgumentException();
        }
        return userInput;
    }
}
