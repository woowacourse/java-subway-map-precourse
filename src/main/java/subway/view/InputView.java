package subway.view;

import java.util.Scanner;

public final class InputView {

    private final Scanner scanner;

    private InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public static InputView of(final Scanner scanner) {
        return new InputView(scanner);
    }
}
