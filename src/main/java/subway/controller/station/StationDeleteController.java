package subway.controller.station;

import subway.controller.Controller;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationDeleteController implements Controller {

    private final InputView inputView;

    public StationDeleteController(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public void run() {
        try {
            String rawStationName = inputView.inputName(InputView.CHOOSE_DELETE_STATION);
            Station.validateName(rawStationName);
            StationRepository.deleteStation(rawStationName);

            OutputView.printInfo(OutputView.INFO_STATION_DELETE);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }
}
