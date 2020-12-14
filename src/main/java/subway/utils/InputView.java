package subway.utils;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner;

    public static void initScanner(Scanner nextScanner) {
        scanner = nextScanner;
    }

    public static String inputSelect() {
        return scanner.nextLine();
    }

    public static String inputName() {
        return scanner.nextLine();
    }

    public static int inputNumber() {
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }
}
