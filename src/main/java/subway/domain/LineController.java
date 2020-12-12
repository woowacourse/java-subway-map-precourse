package subway.domain;

import subway.view.InputView;
import subway.view.OutputView;

public class LineController {

    public static final String LINE = "노선";

    public static final String RANGE = "구간";

    private final LineRepository lineRepository;

    private final InputView inputView;

    private final OutputView outputView;

    public LineController() {
        this.lineRepository = new LineRepository();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public LineController(LineRepository lineRepository, InputView inputView,
                          OutputView outputView) {
        this.lineRepository = lineRepository;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public LineController addLine() {
        String lineName = inputView.inputLineName();
        String startStation = inputView.inputStationName();
        String finalStation = inputView.inputStationName();

        LineRepository addedLineRepository = lineRepository.addLine(new Line(lineName, startStation, finalStation));

        outputView.printSaved(LINE);

        return new LineController(addedLineRepository, this.inputView, this.outputView);
    }

    public LineController removeLine() {
        String lineName = inputView.inputLineName();

        LineRepository removedLineRepository = lineRepository.removeLine(lineName);

        outputView.printRemoved(LINE);

        return new LineController(removedLineRepository, this.inputView, this.outputView);
    }

    public void loadLines() {
        outputView.printLines(lineRepository);
    }

    public LineController insertStation() {
        String lineName = inputView.inputLineName();
        String stationName = inputView.inputStationName();
        int stationIndex = inputView.inputIndex();

        LineRepository rangeInsertedLineRepository = lineRepository.insertStation(lineName, stationIndex, stationName);

        outputView.printSaved(RANGE);

        return new LineController(rangeInsertedLineRepository, this.inputView, this.outputView);
    }

    public LineController removeStation() {
        String lineName = inputView.inputLineName();
        String stationName = inputView.inputStationName();

        LineRepository rangeRemovedLineRepository = lineRepository.removeStation(lineName, stationName);

        outputView.printRemoved(RANGE);

        return new LineController(rangeRemovedLineRepository, this.inputView, this.outputView);
    }

    public void printSubwayMap() {
        outputView.printSubwayMap(lineRepository);
    }
}
