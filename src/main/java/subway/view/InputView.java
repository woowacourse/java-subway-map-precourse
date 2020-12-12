package subway.view;

import subway.exception.InvalidOrderException;
import subway.exception.NoInitialScannerException;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;
    private static InputView instance;

    private static String COMMAND_INPUT_MESSAGE = "## 원하는 기능을 선택하세요.";

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
        System.out.println(COMMAND_INPUT_MESSAGE);
        String input = scanner.nextLine();
        return input;
    }

    public String input() {
        return scanner.nextLine();
    }

    public int inputNumber() {
        String number = scanner.nextLine();

        if (!isNumeric(number)) {
            throw new InvalidOrderException();
        }
        return Integer.parseInt(number);
    }

    private boolean isNumeric(String order) {
        try {
            double aDouble = Double.parseDouble(order);
            int integer = Integer.parseInt(order);

            return aDouble == integer;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
