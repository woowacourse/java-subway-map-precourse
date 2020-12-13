package subway;

import subway.domain.line.model.LineRepository;
import subway.domain.station.model.StationRepository;
import subway.util.DummyData;
import subway.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        DummyData.init();
        OutputView.printStations(StationRepository.stations());
        OutputView.printLines(LineRepository.lines());
    }
}
