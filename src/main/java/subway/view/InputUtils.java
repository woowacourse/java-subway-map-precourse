package subway.view;

import subway.Load;

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
            Load.loadMainScreen();
            return null;
        }
        if(!userInput.matches("[1-"+endInclusive+"]")){
            System.out.println(userInput);
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(userInput);
    }
}
