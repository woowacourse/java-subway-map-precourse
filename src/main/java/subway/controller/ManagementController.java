package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public final class ManagementController {

    public static final String STATION = "역";

    public static final String LINE = "노선";

    public static final String SECTION = "구간";

    private final LineRepository lineRepository;

    private final StationRepository stationRepository;

    public ManagementController() {
        this(new LineRepository(), new StationRepository());
    }

    public ManagementController(final LineRepository lineRepository,
                                final StationRepository stationRepository) {
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
    }

    public LineRepository lines() {
        return lineRepository;
    }

    public StationRepository stations() {
        return stationRepository;
    }

    public ManagementController addStation() {
        final String stationName = InputView.inputStation();

        return addStation(stationName);
    }

    public ManagementController addStation(final String stationName) {
        StationRepository addedRepository = stationRepository.addStation(stationName);

        OutputView.printSaved(STATION);

        return new ManagementController(this.lineRepository, addedRepository);
    }

    public ManagementController removeStation() {
        final String stationName = InputView.inputRemoveStation();

        return removeStation(stationName);
    }

    public ManagementController removeStation(final String stationName) {
        StationRepository removedRepository =
                stationRepository.removeStation(stationName, lineRepository);

        OutputView.printRemoved(STATION);

        return new ManagementController(this.lineRepository, removedRepository);
    }

    public ManagementController loadStations() {
        OutputView.printTitleAndStations(stationRepository);

        return this;
    }

    public ManagementController addLine() {
        final String lineName = InputView.inputLineName();
        final String startStation = InputView.inputStartStation();
        final String finalStation = InputView.inputFinalStation();

        return addLine(lineName, startStation, finalStation);
    }

    public ManagementController addLine(final String lineName, final String startStation,
                                        final String finalStation) {
        LineRepository addedLineRepository =
                lineRepository.addLine(new Line(lineName, startStation, finalStation));

        OutputView.printSaved(LINE);

        return new ManagementController(addedLineRepository, this.stationRepository);
    }

    public ManagementController removeLine() {
        final String lineName = InputView.inputRemoveLineName();

        return removeLine(lineName);
    }

    public ManagementController removeLine(final String lineName) {
        LineRepository removedLineRepository = lineRepository.removeLine(lineName);

        OutputView.printRemoved(LINE);

        return new ManagementController(removedLineRepository, this.stationRepository);
    }

    public ManagementController loadLines() {
        OutputView.printLines(lineRepository);

        return this;
    }

    public ManagementController addSection() {
        final String lineName = InputView.inputLineName();
        final String stationName = InputView.inputStation();
        final int stationIndex = InputView.inputIndex();

        return addSection(lineName, stationName, stationIndex);
    }

    public ManagementController addSection(final String lineName, final String stationName,
                                           final int stationIndex) {
        LineRepository sectionAddedLineRepository =
                lineRepository.addSection(lineName, stationIndex, stationName);

        OutputView.printSaved(SECTION);

        return new ManagementController(sectionAddedLineRepository, this.stationRepository);
    }

    public ManagementController removeSection() {
        final String lineName = InputView.inputLineName();
        final String stationName = InputView.inputStation();

        return removeSection(lineName, stationName);
    }

    public ManagementController removeSection(final String lineName, final String stationName) {
        LineRepository sectionRemovedLineRepository =
                lineRepository.removeSection(lineName, stationName);

        OutputView.printRemoved(SECTION);

        return new ManagementController(sectionRemovedLineRepository, this.stationRepository);
    }

    public ManagementController loadSubwayMap() {
        OutputView.printSubwayMap(lineRepository);

        return this;
    }

    public static ManagementController initialize() {
        String[] stations = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};

        StationRepository stationRepository = new StationRepository()
                .addStations(stations);

        String[] secondLine = {"교대역", "강남역", "역삼역"};
        String[] thirdLine = {"교대역", "남부터미널역", "양재역", "매봉역"};
        String[] sinbundangLine = {"강남역", "양재역", "양재시민의숲역"};

        LineRepository lineRepository = new LineRepository()
                .addLine("2호선", secondLine)
                .addLine("3호선", thirdLine)
                .addLine("신분당선", sinbundangLine);

        return new ManagementController(lineRepository, stationRepository);
    }
}
