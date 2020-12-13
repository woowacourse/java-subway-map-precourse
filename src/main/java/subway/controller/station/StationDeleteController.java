package subway.controller.station;

import subway.controller.Controller;
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
            String deletingStationName = inputView.inputName(InputView.CHOOSE_DELETE_STATION);
            if (!StationRepository.deleteStation(deletingStationName)) {
                throw new IllegalArgumentException(OutputView.ERROR_NO_NAME);
            }
            StationRepository.deleteStation(deletingStationName);
            OutputView.printInfo(OutputView.INFO_STATION_DELETE);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }
}
