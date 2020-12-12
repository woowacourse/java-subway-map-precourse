package subway;

import java.util.Scanner;
import subway.domain.function.MainFunction;
import subway.view.InputView;
import subway.view.OutputView;

public class Machine {
    public void start(Scanner scanner) {
        try {
            OutputView.printMainFunctions();
            String mainFunctionNumber = InputView.inputFunctionNumber(scanner);
            if (mainFunctionNumber.equals("Q")) {
                return;
            }
            MainFunction.getMainFunctionByNumber(mainFunctionNumber).operate(scanner);
            start(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            OutputView.printEmptyLine();
            start(scanner);
        }

    }
}
