package subway;

import subway.controller.MainScreen;

import java.util.Scanner;

public class InputUtils {
    static Scanner scanner = new Scanner(System.in);

    public static int createMainInput(int endInclusive, String returnOption) {
        System.out.println("## 원하는 기능을 선택하세요.");
        try {
            return validateMainInput(scanner.nextLine(), endInclusive, returnOption);
        } catch (IllegalArgumentException e) {
            System.err.println(e);
            createMainInput(endInclusive, returnOption);
        }
        return 0;
    }

    public static Integer validateMainInput(String userInput, int endInclusive, String returnOption) {
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
