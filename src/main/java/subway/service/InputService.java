package subway.service;

import java.util.Scanner;

public class InputService {
    private final Scanner scanner;

    private InputService(Scanner scanner) {
        this.scanner = scanner;
    }

    public static InputService of(Scanner scanner) {
        return new InputService(scanner);
    }
}
