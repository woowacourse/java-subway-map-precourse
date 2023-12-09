package subway.controller.station;

import java.util.List;
import subway.domain.Station;
import subway.domain.StationOption;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationFindController implements SubStationController {
    private final InputView inputView;
    private final OutputView outputView;

    public StationFindController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public StationOption process() {
        List<Station> stations = StationRepository.stations();
        outputView.printAllStations(stations);
        return StationOption.LIST;
    }
}
