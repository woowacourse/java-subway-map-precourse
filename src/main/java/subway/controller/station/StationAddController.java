package subway.controller.station;

import static subway.exception.ExceptionMessage.STATION_ALREADY_EXISTS;
import static subway.util.Retry.retry;

import subway.domain.Station;
import subway.domain.StationOption;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationAddController implements SubStationController {
    private final InputView inputView;
    private final OutputView outputView;

    public StationAddController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public StationOption process() {
        Station station = retry(this::getStation);
        StationRepository.addStation(station);
        outputView.printAddStation();
        return StationOption.ADD;
    }

    private Station getStation() {
        Station station = inputView.readAddStation();
        if (StationRepository.contains(station)) {
            throw new IllegalArgumentException(STATION_ALREADY_EXISTS.getMessage());
        }
        return station;
    }
}
