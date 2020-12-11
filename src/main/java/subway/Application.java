package subway;

import java.util.Scanner;
import subway.domain.function.Function;
import subway.domain.function.Functions;
import subway.view.InputView;
import subway.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Machine machine = new Machine();

        while (true) {
            OutputView.printMainFunctions();
            String mainFunctionsNumber = InputView.inputFunctionNumber(scanner);
            // 메인 화면에서 종료
            if (mainFunctionsNumber.equals("Q")) {
                break;
            }
            Functions mainFunctions = machine.selectMainFunctions(mainFunctionsNumber);

            // 서브 기능
            String functionNumber = InputView.inputFunctionNumber(scanner);
            Function function = mainFunctions.selectFunction(functionNumber);
            System.out.println(function);
            function.operateFunction();
        }
    }
}
