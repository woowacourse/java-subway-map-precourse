package subway.controller.station;

import static subway.util.SubwayValidator.validateStationContainedAnyLine;
import static subway.util.SubwayValidator.validateStationExist;

import subway.controller.SubController;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationRemoveController implements SubController {
    private final InputView inputView;
    private final OutputView outputView;

    public StationRemoveController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        try {
            Station station = getStation();
            StationRepository.deleteStation(station.getName());
            outputView.printRemoveStation();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private Station getStation() {
        Station station = inputView.readRemoveStation();
        validateStationExist(station);
        validateStationContainedAnyLine(station);
        return station;
    }
}
