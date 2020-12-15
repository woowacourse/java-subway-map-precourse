package subway.view;

import java.util.Scanner;

public class SubwayView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String userInput() {
        return scanner.nextLine();
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void newLine() {
        System.out.println();
    }
}
