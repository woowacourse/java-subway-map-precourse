package subway.domain.function.station;

import java.util.Scanner;
import subway.domain.StationRepository;
import subway.domain.function.Function;
import subway.view.OutputView;

public class StationReadFunction extends Function {
    @Override
    public void operateFunction(Scanner scanner) {
        OutputView.printStations(StationRepository.stations());
    }
}
