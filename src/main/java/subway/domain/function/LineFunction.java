package subway.domain.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public enum LineFunction {
    CREATE("1") {
        @Override
        public void operate(Scanner scanner) {
            String lineName = getInputLineName(scanner);
            String upwardTerminalStationName =
                LineFunction.getInputUpwardTerminalStationName(scanner);
            Station upwardTerminalStation = new Station(upwardTerminalStationName);
            String downwardTerminalStationName = getInputDownwardTerminalStationName(scanner);
            Station downwardTerminalStation = new Station(downwardTerminalStationName);
            validateOverlappedInTerminalStations(upwardTerminalStation, downwardTerminalStation);
            LineRepository.addLine(new Line(lineName, new ArrayList<>(Arrays.asList(
                upwardTerminalStation,
                downwardTerminalStation
            ))));
            OutputView.printSuccessToCreateLine();
            // TODO - 디버깅용
            System.out.println(LineRepository.lines());
        }
    },
    DELETE("2") {
        @Override
        public void operate(Scanner scanner) {
            String lineName = InputView.inputLineToDelete(scanner);
            LineRepository.deleteLineByName(lineName);
            OutputView.printSuccessToDeleteLine();
            // TODO - 디버깅용
            System.out.println(LineRepository.lines());

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

    private static String getInputLineName(Scanner scanner) {
        String lineName = InputView.inputLineNameToCreate(scanner);
        validateLineName(lineName);
        return lineName;
    }

    private static void validateLineName(String lineName) {
        Line.validateLineName(lineName);
        LineRepository.validateOverlappedLineName(lineName);
    }

    private static String getInputUpwardTerminalStationName(Scanner scanner) {
        String upwardTerminalStationName = InputView.inputUpwardTerminalStationName(scanner);
        validateUpwardTerminalStation(new Station(upwardTerminalStationName));
        return upwardTerminalStationName;
    }

    private static void validateUpwardTerminalStation(Station station) {
        if (!StationRepository.contains(station)) {
            throw new IllegalArgumentException("[ERROR] 미리 등록된 역이여야만 가능합니다.");
        }
    }

    private static String getInputDownwardTerminalStationName(Scanner scanner) {
        String downwardTerminalStationName = InputView.inputDownwardTerminalStationName(scanner);
        validateDownwardTerminalStation(new Station(downwardTerminalStationName));
        return downwardTerminalStationName;
    }

    private static void validateDownwardTerminalStation(Station downwardTerminalStation) {
        if (!StationRepository.contains(downwardTerminalStation)) {
            throw new IllegalArgumentException("[ERROR] 미리 등록된 역이여야만 가능합니다.");
        }
    }

    private static void validateOverlappedInTerminalStations(
        Station upwardTerminalStation,
        Station downwardTerminalStation
    ) {
        if (upwardTerminalStation.equals(downwardTerminalStation)) {
            throw new IllegalArgumentException("[ERROR] 상행 종점역과 하행 종점역이 같을 수는 없습니다.");
        }
    }

    public abstract void operate(Scanner scanner);
}
