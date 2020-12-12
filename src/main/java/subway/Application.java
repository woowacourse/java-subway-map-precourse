package subway;

import java.util.Scanner;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.domain.function.MainFunction;
import subway.view.InputView;
import subway.view.OutputView;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(LineRepository.lines());
        System.out.println(StationRepository.stations());

        while (true) {
            OutputView.printMainFunctions();
            String mainFunctionNumber = InputView.inputFunctionNumber(scanner);
            if (mainFunctionNumber.equals("Q")) {
                break;
            }
            MainFunction.getMainFunctionByNumber(mainFunctionNumber).operate(scanner);
        }
    }
}
