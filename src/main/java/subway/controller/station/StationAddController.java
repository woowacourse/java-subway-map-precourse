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
            String addingStationName = inputView.inputName(InputView.CHOOSE_STATION_ADD);
            StationRepository.addStation(new Station(addingStationName));
            OutputView.printInfo(InfoMessage.STATION_ADDED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }
}
