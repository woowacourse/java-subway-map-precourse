package subway.domain.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

public enum LineFunction {
    CREATE("1") {
        @Override
        public void operate(Scanner scanner) {
            String lineName = InputView.inputLineNameToCreate(scanner);
            String UpwardTerminalStationName = InputView.inputUpwardTerminalStationName(scanner);
            String DownwardTerminalStationName = InputView.inputDownwardTerminalStationName(scanner);
            LineRepository.addLine(new Line(lineName, new ArrayList<Station>(Arrays.asList(
                new Station(UpwardTerminalStationName),
                new Station(DownwardTerminalStationName))
            )));
            OutputView.printSuccessToCreateLine();
        }
    },
    DELETE("2") {
        @Override
        public void operate(Scanner scanner) {
            String lineName = InputView.inputLineToDelete(scanner);
            LineRepository.deleteLineByName(lineName);
            OutputView.printSuccessToDeleteLine();
        }
    },
    READ("3") {
        @Override
        public void operate(Scanner scanner) {
            OutputView.printLine(LineRepository.lines());
        }
    },
    BACK("B") {
        @Override
        public void operate(Scanner scanner) {
        }
    };

    private String number;

    LineFunction(String number) {
        this.number = number;
    }

    public static LineFunction getLineFunctionByNumber(String inputNumber) {
        return Arrays.stream(LineFunction.values())
            .filter(function -> function.number.equals(inputNumber))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다."));
    }

    public abstract void operate(Scanner scanner);
}
