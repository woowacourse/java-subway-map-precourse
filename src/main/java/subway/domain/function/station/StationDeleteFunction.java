package subway.domain.function.station;

import java.util.Scanner;
import subway.domain.StationRepository;
import subway.domain.function.Function;
import subway.view.InputView;

public class StationDeleteFunction extends Function {
    @Override
    public void operateFunction(Scanner scanner) {
        String stationName = InputView.inputStationToDelete(scanner);
        StationRepository.deleteStation(stationName);
        System.out.println(StationRepository.stations());
    }
}
