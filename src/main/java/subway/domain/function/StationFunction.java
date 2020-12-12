package subway.domain.function;

import java.util.Arrays;
import java.util.Scanner;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public enum StationFunction {
    CREATE("1") {
        @Override
        public void operate(Scanner scanner) {
            String station = InputView.inputStationToCreate(scanner);
            StationRepository.addStation(new Station(station));
            OutputView.printSuccessToCreateStation();
            System.out.println(StationRepository.stations());
        }
    },
    DELETE("2") {
        @Override
        public void operate(Scanner scanner) {
            String stationName = InputView.inputStationToDelete(scanner);
            StationRepository.deleteStation(stationName);
            OutputView.printSuccessToDeleteStation();
            System.out.println(StationRepository.stations());
        }
    },
    READ("3") {
        @Override
        public void operate(Scanner scanner) {
            OutputView.printStations(StationRepository.stations());
        }
    },
    BACK("B") {
        @Override
        public void operate(Scanner scanner) {
        }
    };

    private String number;

    StationFunction(String number) {
        this.number = number;
    }

    public static StationFunction getStationFunctionByNumber(String inputNumber) {
        return Arrays.stream(StationFunction.values())
            .filter(function -> function.number.equals(inputNumber))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다."));
    }

    public abstract void operate(Scanner scanner);
}
