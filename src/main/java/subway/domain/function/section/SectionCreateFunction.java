package subway.domain.function.section;

import java.util.Scanner;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.function.Function;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionCreateFunction extends Function {
    @Override
    public void operateFunction(Scanner scanner) {
        String lineName = InputView.inputLineName(scanner);
        String stationName = InputView.inputStationName(scanner);
        int order = Integer.parseInt(InputView.inputOrder(scanner));
        LineRepository.addStation(lineName, stationName, order);
    }
}
