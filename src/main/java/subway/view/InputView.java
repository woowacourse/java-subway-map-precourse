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
            OutputView.printMsg("다시 입력해주세요\n");
            return getInteger(scanner);
        }
    }

    public static Name getName(Scanner scanner) {
        try {
            return new Name(getInput(scanner));
        } catch (Exception e) {
            OutputView.printErrorMsg(e);
            OutputView.printMsg("다시 입력해주세요\n");
            return getName(scanner);
        }
    }

    public static String getInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
