package subway.view;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static String input() {
        return scanner.nextLine();
    }
}
