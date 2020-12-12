package subway.domain.function;

import java.util.Arrays;
import java.util.Scanner;
import subway.domain.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;

public enum MainFunction {
    MANAGING_STATION("1") {
        @Override
        public void operate(Scanner scanner) {
            OutputView.printStationFunctions();
            String functionNumber = InputView.inputFunctionNumber(scanner);
            StationFunction.getStationFunctionByNumber(functionNumber).operate(scanner);
        }
    },
    MANAGING_LINE("2") {
        @Override
        public void operate(Scanner scanner) {
            OutputView.printLineFunctions();
            String functionNumber = InputView.inputFunctionNumber(scanner);
            LineFunction.getLineFunctionByNumber(functionNumber).operate(scanner);
        }
    },
    MANAGING_SECTION("3") {
        @Override
        public void operate(Scanner scanner) {
            OutputView.printSectionFunctions();
            String functionNumber = InputView.inputFunctionNumber(scanner);
            SectionFunction.getSectionFunctionByNumber(functionNumber).operate(scanner);
        }
    },
    PRINT_SUBWAY_MAP("4") {
        @Override
        public void operate(Scanner scanner) {
            OutputView.printSubwayMap(LineRepository.lines());
        }
    },
    QUIT("Q") {
        @Override
        public void operate(Scanner scanner) {
        }
    };

    private String number;

    MainFunction(String number) {
        this.number = number;
    }

    public static MainFunction getMainFunctionByNumber(String inputNumber) {
        return Arrays.stream(MainFunction.values())
            .filter(function -> function.number.equals(inputNumber))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다."));
    }

    public abstract void operate(Scanner scanner);
}
