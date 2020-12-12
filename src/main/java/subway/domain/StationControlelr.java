package subway.domain;

import subway.view.InputView;
import subway.view.OutputView;

public class StationControlelr {

    private final StationRepository stationRepository;

    private final InputView inputView;

    private final OutputView outputView;

    public StationControlelr() {
        this.inputView = new InputView();
        this.stationRepository = new StationRepository();
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
}
