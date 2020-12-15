package subway.controller;

import java.util.Scanner;

public class MainController {
    private static final int INPUT_LENGTH = 1;
    private static final int MIN_MAIN_MENU_VALUE = 1;
    private static final int MAX_MAIN_MENU_VALUE = 4;
    private static final String QUIT_VALUE = "Q";
    private static final String INFO = "[INFO] ";
    private static final String ERROR = "[ERROR] ";
    private static final String INPUT_VALUE_ERROR_MESSAGE = "입력값이 잘못되었습니다.";

    public static String selectMenu(Scanner scanner) {
        String input = scanner.next();
        validateInput(input);
        return input;
    }

    private static void validateInput(String input) {
        if(input.equals(QUIT_VALUE)) {
            return;
        }
        if(input.length() == INPUT_LENGTH && Character.isDigit(input.charAt(0))) {
            int select = Integer.parseInt(input);
            if(select >= MIN_MAIN_MENU_VALUE && select <= MAX_MAIN_MENU_VALUE) {
                return;
            }
        }
        printError(INPUT_VALUE_ERROR_MESSAGE);
    }

    private static void printError(String message) {
        System.out.println(ERROR + message);
        throw new IllegalStateException();
    }

    private static void printInfo(String message) {
        System.out.println(INFO + message);
    }
}
