package subway.controller.station;

import java.util.List;
import subway.controller.SubController;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationFindController implements SubController {
    private final InputView inputView;
    private final OutputView outputView;

    public StationFindController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        List<Station> stations = StationRepository.stations();
        outputView.printAllStations(stations);
    }
}
