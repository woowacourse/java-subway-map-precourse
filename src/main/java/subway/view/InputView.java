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
        int value = -1;

        try {
            value = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }

        if (value < 1) {
            return -1;
        }
        return value;
    }
}
