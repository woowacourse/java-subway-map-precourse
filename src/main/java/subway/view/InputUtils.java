package subway.view;

import java.util.Scanner;

public class InputUtils {
    static Scanner scanner = new Scanner(System.in);

    public static Integer createUserSelectionInput(int endInclusive, String returnOption) {
        boolean isValidInput = false;
        while (!isValidInput) {
            System.out.println("## 원하는 기능을 선택하세요.");
            try {
                return validateUserSelectionInput(getUserInput(), endInclusive, returnOption);
            } catch (IllegalArgumentException e) {
                System.err.println("[ERROR] 선택할 수 없는 기능입니다.");
                isValidInput = false;
            }
        }
        return null;
    }

    public static String getUserInput() {
        return scanner.nextLine();
    }

    public static Integer validateUserSelectionInput(String userInput, int endInclusive, String returnOption) {
        userInput = userInput.toUpperCase();
        if (userInput.equals(returnOption) && returnOption.equals("Q")) {
            System.exit(0);
        }
        if (userInput.equals(returnOption) && returnOption.equals("B")) {
            MainScreen mainScreen = new MainScreen();
            mainScreen.start();
            return null;
        }
        int userIntInput = Integer.parseInt(userInput);
        if (!(userIntInput > 0 && userIntInput <= endInclusive)) {
            throw new IllegalArgumentException();
        }
        return userIntInput;
    }
}
