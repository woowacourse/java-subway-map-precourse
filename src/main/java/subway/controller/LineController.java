package subway.controller;

import java.util.Scanner;

public class LineController {
    private static LineController lineController = null;
    private final Scanner scanner;

    private LineController(Scanner scanner) {
        this.scanner = scanner;
    }

    public static LineController getInstance(Scanner scanner) {
        if (lineController == null) {
            return new LineController(scanner);
        }
        return lineController;
    }
}
