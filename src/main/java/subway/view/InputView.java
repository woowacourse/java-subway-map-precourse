package subway.view;

import subway.domain.Name;

import java.util.Scanner;

public class InputView {
    private InputView() {
    }

    public static int getInteger(Scanner scanner) {
        try {
            return Integer.parseInt(getInput(scanner));
        } catch (Exception e) {
            OutputView.printErrorMsg(e);
            return getInteger(scanner);
        }
    }

    public static Name getName(Scanner scanner) {
        try {
            return new Name(getInput(scanner));
        } catch (Exception e) {
            OutputView.printErrorMsg(e);
            return getName(scanner);
        }
    }

    public static String getInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
