package subway.view;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static String inputMainMenu() {
        return scanner.nextLine();
    }
}
