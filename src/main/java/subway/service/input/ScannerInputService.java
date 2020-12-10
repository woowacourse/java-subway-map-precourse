package subway.service.input;

import java.util.Scanner;

public class ScannerInputService implements InputService {
    private final Scanner scanner;

    private ScannerInputService(Scanner scanner) {
        this.scanner = scanner;
    }

    public static ScannerInputService of(Scanner scanner) {
        return new ScannerInputService(scanner);
    }
}
