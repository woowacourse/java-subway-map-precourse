package subway.controller.station;

import subway.controller.Controller;
import subway.domain.station.StationRepository;
import subway.view.ErrorMessage;
import subway.view.InfoMessage;
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
                throw new IllegalArgumentException(ErrorMessage.STATION_NOTHING);
            }
            StationRepository.deleteStation(deletingStationName);
            OutputView.printInfo(InfoMessage.STATION_DELETED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }
}
