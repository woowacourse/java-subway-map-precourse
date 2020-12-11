package subway.view;

import java.util.Scanner;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in);

    public static String receiveMenu() {
        return SCANNER.nextLine();
    }
}
