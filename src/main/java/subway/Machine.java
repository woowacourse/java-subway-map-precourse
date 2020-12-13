package subway;

import java.util.Scanner;
import subway.domain.function.MainFunction;
import subway.view.InputView;
import subway.view.OutputView;

public class Machine {
    private static final String QUIT_NUMBER = "Q";

    public void start(Scanner scanner) {
        try {
            OutputView.printMainFunctions();
            String mainFunctionNumber = InputView.inputFunctionNumber(scanner);
            if (mainFunctionNumber.equals(QUIT_NUMBER)) {
                return;
            }
            MainFunction.getMainFunctionByNumber(mainFunctionNumber).operate(scanner);
            start(scanner);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            start(scanner);
        }

    }
}
