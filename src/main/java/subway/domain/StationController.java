package subway.domain;

import subway.view.InputView;
import subway.view.OutputView;

public class StationController {

    public static final String STATION = "역";

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

        outputView.printSaved(STATION);
    }

    public void remove() {
        String stationName = inputView.inputStationName();

        stationRepository.removeStation(stationName);

        outputView.printRemoved(STATION);
    }

    public void load() {
        outputView.printStations(stationRepository);
    }
}
