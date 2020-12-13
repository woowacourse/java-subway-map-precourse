package subway.controller.station;

import subway.controller.Controller;
import subway.domain.station.StationRepository;
import subway.view.OutputView;

public class StationViewController implements Controller {

    @Override
    public void run() {
        OutputView.printStations(StationRepository.stations());
    }
}
