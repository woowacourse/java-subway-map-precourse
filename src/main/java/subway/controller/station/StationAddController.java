package subway.controller.station;

import subway.controller.Controller;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.view.InfoMessage;
import subway.view.InputView;
import subway.view.OutputView;

public class StationAddController implements Controller {

    private final InputView inputView;

    public StationAddController(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public void run() {
        try {
            StationRepository.addStation(new Station(getAddingStationName()));
            OutputView.printInfo(InfoMessage.STATION_ADDED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }

    private String getAddingStationName() {
        return inputView.inputName(InputView.CHOOSE_STATION_ADD);
    }
}
