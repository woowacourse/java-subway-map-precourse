package subway.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputName() {
        return scanner.nextLine().trim();
    }

    public int inputNumber() {
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}
