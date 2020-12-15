package subway.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }


    private String userInputString() {
        return scanner.nextLine();
    }

    public String getSelectedServiceInput() {
        return userInputString();
    }

    public String getSelectedFunctionInput() {
        return userInputString();
    }

    public String getLineName() {
        return userInputString();
    }

    public String getStationName() {
        return userInputString();
    }

    public int getOrder() throws NumberFormatException {
        return Integer.parseInt(scanner.nextLine()) - 1;
    }
}
