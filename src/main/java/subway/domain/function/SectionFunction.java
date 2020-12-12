package subway.domain.function;

import java.util.Arrays;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Order;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public enum SectionFunction {
    CREATE("1") {
        @Override
        public void operate(Scanner scanner) {
            String lineName = InputView.inputLineName(scanner);
            Line line = LineRepository.findByName(lineName);
            String stationName = getInputStationName(scanner, line);
            Order order = new Order(InputView.inputOrder(scanner), line);
            LineRepository.addStation(lineName, stationName, order);
            OutputView.printSuccessToCreateSection();
            // TODO - 디버깅용
            System.out.println(LineRepository.lines());
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

    private static String getInputStationName(Scanner scanner, Line line) {
        String stationName = InputView.inputStationName(scanner);
        if (line.contains(stationName)) {
            throw new IllegalArgumentException("[ERROR] 해당 노선에서 이미 존재하는 역은 등록이 불가능합니다.");
        }
        if (!StationRepository.contains(new Station(stationName))) {
            throw new IllegalArgumentException("[ERROR] 미리 등록된 역만 입력이 가능합니다.");
        }
        return stationName;
    }

    public abstract void operate(Scanner scanner);
}
