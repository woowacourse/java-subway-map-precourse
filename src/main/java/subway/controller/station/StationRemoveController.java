package subway.controller.station;

import static subway.exception.ExceptionMessage.INVALID_REMOVE_STATION_IN_LINE;
import static subway.exception.ExceptionMessage.NOT_FOUND_STATION;

import subway.controller.SubController;
import subway.domain.LineRepository;
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
        if (!StationRepository.contains(station)) {
            throw new IllegalArgumentException(NOT_FOUND_STATION.getMessage());
        }
        if (LineRepository.containsStation(station)) {
            throw new IllegalArgumentException(INVALID_REMOVE_STATION_IN_LINE.getMessage());
        }
        return station;
    }
}
