package subway.view;

import java.util.Scanner;

public class InputView {

    final Scanner scanner = new Scanner(System.in);

    OutputView outputView = new OutputView();

    public String getInput(String selectFunction) {
        outputView.printSelectFunction(selectFunction);
        return scanner.nextLine();
    }
}
