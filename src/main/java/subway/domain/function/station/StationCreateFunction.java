package subway.domain.function.station;

import java.util.Scanner;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.function.Function;
import subway.view.InputView;
import subway.view.OutputView;

public class StationCreateFunction extends Function {
    @Override
    public void operateFunction(Scanner scanner) {
        String station = InputView.inputStationToCreate(scanner);
        StationRepository.addStation(new Station(station));
        OutputView.printSuccessToCreateStation();
        System.out.println(StationRepository.stations());
    }
}
