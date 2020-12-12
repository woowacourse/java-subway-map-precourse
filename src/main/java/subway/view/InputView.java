package subway.view;

import subway.exception.NoInitialScannerException;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;
    private static InputView instance;

    private InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void initScanner(Scanner scanner) {
        instance = new InputView(scanner);
    }

    public static InputView getInstance() {

        if (instance == null) {
            throw new NoInitialScannerException();
        }

        return instance;
    }

    public String selectMenu() {
        return scanner.nextLine();
    }

    public String inputName() {
        return scanner.nextLine();
    }

}
