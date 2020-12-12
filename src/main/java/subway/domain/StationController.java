package subway.domain;

import subway.view.InputView;
import subway.view.OutputView;

public class StationController {

    public static final String STATION = "역";

    private final StationRepository stationRepository;

    private final InputView inputView;

    private final OutputView outputView;

    public StationController(InputView inputView,
                             OutputView outputView) {
        this(new StationRepository(), inputView, outputView);
    }

    public StationController(StationRepository stationRepository, InputView inputView,
                             OutputView outputView) {
        this.stationRepository = stationRepository;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public StationController add() {
        String stationName = inputView.inputStationName();

        StationRepository addedRepository = stationRepository.addStation(stationName);

        outputView.printSaved(STATION);

        return new StationController(addedRepository, this.inputView, this.outputView);
    }

    public StationController remove() {
        String stationName = inputView.inputStationName();

        StationRepository removedRepository = stationRepository.removeStation(stationName);

        outputView.printRemoved(STATION);

        return new StationController(removedRepository, this.inputView, this.outputView);
    }

    public StationController load() {
        outputView.printStations(stationRepository);

        return this;
    }
}
