package subway.controller.station;

import static subway.util.Retry.retry;
import static subway.util.SubwayValidator.validateStationExist;

import subway.controller.SubController;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationAddController implements SubController {
    private final InputView inputView;
    private final OutputView outputView;

    public StationAddController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        Station station = retry(this::getStation);
        StationRepository.addStation(station);
        outputView.printAddStation();
    }

    private Station getStation() {
        Station station = inputView.readAddStation();
        validateStationExist(station);
        return station;
    }
}
