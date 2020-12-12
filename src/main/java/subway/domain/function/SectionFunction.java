package subway.domain.function;

import java.util.Arrays;
import java.util.Scanner;
import subway.domain.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;

public enum SectionFunction {
    CREATE("1") {
        @Override
        public void operate(Scanner scanner) {
            String lineName = InputView.inputLineName(scanner);
            String stationName = InputView.inputStationName(scanner);
            int order = Integer.parseInt(InputView.inputOrder(scanner));
            LineRepository.addStation(lineName, stationName, order);
            OutputView.printSuccessToCreateSection();
        }
    },
    DELETE("2") {
        @Override
        public void operate(Scanner scanner) {
            String lineName = InputView.inputLineNameToDeleteSection(scanner);
            String stationName = InputView.inputStationNameInLineToDelete(scanner);
            LineRepository.deleteStation(lineName, stationName);
            OutputView.printSuccessToDeleteSection();
        }
    },
    BACK("B") {
        @Override
        public void operate(Scanner scanner) {
        }
    };

    private String number;

    SectionFunction(String number) {
        this.number = number;
    }

    public static SectionFunction getSectionFunctionByNumber(String inputNumber) {
        return Arrays.stream(SectionFunction.values())
            .filter(function -> function.number.equals(inputNumber))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다."));
    }

    public abstract void operate(Scanner scanner);
}
