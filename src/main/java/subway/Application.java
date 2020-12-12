package subway;

import java.util.Scanner;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.domain.function.Function;
import subway.domain.function.Functions;
import subway.view.InputView;
import subway.view.OutputView;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Machine machine = new Machine();
        System.out.println(LineRepository.lines());
        System.out.println(StationRepository.stations());

        while (true) {
            OutputView.printMainFunctions();
            String mainFunctionNumber = getInputMainFunctionNumber(scanner);
            if (mainFunctionNumber.equals("Q")) {
                break;
            }
            if (mainFunctionNumber.equals("4")) {
                OutputView.printSubwayMap(LineRepository.lines());
            }
            Functions mainFunctions = machine.selectMainFunctions(mainFunctionNumber);

            // 서브 기능
            OutputView.printFunctions(mainFunctionNumber);
            String functionNumber = InputView.inputFunctionNumber(scanner);
            Function function = mainFunctions.selectFunction(functionNumber);
            function.operateFunction(scanner);
        }
    }

    private static String getInputMainFunctionNumber(Scanner scanner) {
        try {
            String mainFunctionNumber = InputView.inputFunctionNumber(scanner);
            validateMainFunctionNumber(mainFunctionNumber);
            return mainFunctionNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputMainFunctionNumber(scanner);
        }
    }

    private static void validateMainFunctionNumber(String mainFunctionNumber) {
        if (!mainFunctionNumber.equals("1")
            && !mainFunctionNumber.equals("2")
            && !mainFunctionNumber.equals("3")
            && !mainFunctionNumber.equals("4")
            && !mainFunctionNumber.equals("Q")
        ) {
            throw new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다.");
        }
    }
}
