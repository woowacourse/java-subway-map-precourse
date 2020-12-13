package subway.domain;

import subway.view.InputView;
import subway.view.OutputView;

public class ManageController {

    public static final String STATION = "역";

    public static final String LINE = "노선";

    public static final String RANGE = "구간";

    private final LineRepository lineRepository;

    private final StationRepository stationRepository;

    public ManageController() {
        this(new LineRepository(), new StationRepository());
    }

    public ManageController(LineRepository lineRepository,
                            StationRepository stationRepository) {
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
    }

    public ManageController addStation() {
        String stationName = InputView.inputStationName();

        StationRepository addedRepository = stationRepository.addStation(stationName);

        OutputView.printSaved(STATION);

        return new ManageController(this.lineRepository, addedRepository);
    }

    public ManageController removeStation() {
        String stationName = InputView.inputStationName();

        StationRepository removedRepository = stationRepository.removeStation(stationName);

        OutputView.printRemoved(STATION);

        return new ManageController(this.lineRepository, removedRepository);
    }

    public ManageController loadStations() {
        OutputView.printStations(stationRepository);

        return this;
    }

    public ManageController addLine() {
        String lineName = InputView.inputLineName();
        String startStation = InputView.inputStationName();
        String finalStation = InputView.inputStationName();

        LineRepository addedLineRepository =
                lineRepository.addLine(new Line(lineName, startStation, finalStation));

        OutputView.printSaved(LINE);

        return new ManageController(addedLineRepository, this.stationRepository);
    }

    public ManageController removeLine() {
        String lineName = InputView.inputLineName();

        LineRepository removedLineRepository = lineRepository.removeLine(lineName);

        OutputView.printRemoved(LINE);

        return new ManageController(removedLineRepository, this.stationRepository);
    }

    public ManageController loadLines() {
        OutputView.printLines(lineRepository);

        return this;
    }

    public ManageController addRange() {
        String lineName = InputView.inputLineName();
        String stationName = InputView.inputStationName();
        int stationIndex = InputView.inputIndex();

        LineRepository rangeInsertedLineRepository =
                lineRepository.addRange(lineName, stationIndex, stationName);

        OutputView.printSaved(RANGE);

        return new ManageController(rangeInsertedLineRepository, this.stationRepository);
    }

    public ManageController removeRange() {
        String lineName = InputView.inputLineName();
        String stationName = InputView.inputStationName();

        LineRepository rangeRemovedLineRepository =
                lineRepository.removeRange(lineName, stationName);

        OutputView.printRemoved(RANGE);

        return new ManageController(rangeRemovedLineRepository, this.stationRepository);
    }

    public ManageController loadSubwayMap() {
        OutputView.printSubwayMap(lineRepository);

        return this;
    }
}
