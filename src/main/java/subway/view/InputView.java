package subway.view;

import java.util.Scanner;

public class InputView {
    private String inputData;

    public String getInputData() {
        return inputData;
    }

    public void scanData(Scanner scanner) {
        inputData = scanner.nextLine();
        System.out.println();
    }
}
