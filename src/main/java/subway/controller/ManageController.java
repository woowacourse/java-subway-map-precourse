package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
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

    public LineRepository lines() {
        return lineRepository;
    }

    public StationRepository stations() {
        return stationRepository;
    }

    public ManageController addStation(String stationName) {
        StationRepository addedRepository = stationRepository.addStation(stationName);

        OutputView.printSaved(STATION);

        return new ManageController(this.lineRepository, addedRepository);
    }

    public ManageController removeStation(String stationName) {
        StationRepository removedRepository =
                stationRepository.removeStation(stationName, lineRepository);

        OutputView.printRemoved(STATION);

        return new ManageController(this.lineRepository, removedRepository);
    }

    public ManageController loadStations() {
        OutputView.printTitleAndStations(stationRepository);

        return this;
    }

    public ManageController addLine(String lineName, String startStation, String finalStation) {
        LineRepository addedLineRepository =
                lineRepository.addLine(new Line(lineName, startStation, finalStation));

        OutputView.printSaved(LINE);

        return new ManageController(addedLineRepository, this.stationRepository);
    }

    public ManageController removeLine(String lineName) {
        LineRepository removedLineRepository = lineRepository.removeLine(lineName);

        OutputView.printRemoved(LINE);

        return new ManageController(removedLineRepository, this.stationRepository);
    }

    public ManageController loadLines() {
        OutputView.printLines(lineRepository);

        return this;
    }

    public ManageController addRange(String lineName, String stationName, int stationIndex) {
        LineRepository rangeInsertedLineRepository =
                lineRepository.addRange(lineName, stationIndex, stationName);

        OutputView.printSaved(RANGE);

        return new ManageController(rangeInsertedLineRepository, this.stationRepository);
    }

    public ManageController removeRange(String lineName, String stationName) {
        LineRepository rangeRemovedLineRepository =
                lineRepository.removeRange(lineName, stationName);

        OutputView.printRemoved(RANGE);

        return new ManageController(rangeRemovedLineRepository, this.stationRepository);
    }

    public ManageController loadSubwayMap() {
        OutputView.printSubwayMap(lineRepository);

        return this;
    }

    public static ManageController initialize() {
        String[] stations = { "교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역" };

        String[] secondLine = {"교대역", "강남역", "역삼역"};
        String[] thirdLine = {"교대역", "남부터미널역", "양재역", "매봉역"};
        String[] sinbundangLine = {"강남역", "양재역", "양재시민의숲역"};

        StationRepository stationRepository = new StationRepository()
                .addStations(stations);

        LineRepository lineRepository = new LineRepository()
                .addLine("2호선", secondLine)
                .addLine("3호선", thirdLine)
                .addLine("신분당선", sinbundangLine);

        return new ManageController(lineRepository, stationRepository);
    }
}
