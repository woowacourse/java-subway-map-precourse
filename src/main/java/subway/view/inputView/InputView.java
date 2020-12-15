package subway.view.inputView;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String scan() {
        return scanner.nextLine();
    }
}
