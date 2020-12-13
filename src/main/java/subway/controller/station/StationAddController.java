package subway.controller.station;

import subway.controller.Controller;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.utils.StationValidator;
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
            String addingStationName = inputView.inputName(InputView.CHOOSE_ADD_STATION);
            StationValidator.validateName(addingStationName);
            StationRepository.addStation(new Station(addingStationName));
            OutputView.printInfo(OutputView.INFO_STATION_ADD);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }
}
