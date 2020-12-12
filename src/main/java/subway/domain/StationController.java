package subway.domain;

import subway.view.InputView;
import subway.view.OutputView;

public class StationController {

    private final StationRepository stationRepository;

    private final InputView inputView;

    private final OutputView outputView;

    public StationController() {
        this.stationRepository = new StationRepository();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void add() {
        String stationName = inputView.inputStationName();

        stationRepository.addStation(stationName);

        outputView.printStationSaved();
    }

    public void remove() {
        String stationName = inputView.inputStationName();

        stationRepository.removeStation(stationName);

        outputView.printStationRemoved();
    }

    public void load() {
        outputView.printStations(stationRepository);
    }
}
