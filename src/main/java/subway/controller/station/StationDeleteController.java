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
            deleteStation(getDeletingStationName());
            OutputView.printInfo(InfoMessage.STATION_DELETED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }

    private void deleteStation(String deletingStationName) {
        if (!StationRepository.deleteStation(deletingStationName)) {
            throw new IllegalArgumentException(ErrorMessage.STATION_NOTHING);
        }
    }

    private String getDeletingStationName() {
        return inputView.inputName(InputView.CHOOSE_STATION_DELETE);
    }
}
