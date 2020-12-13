package subway.domain;

import subway.view.InputView;
import subway.view.OutputView;

public class LineController {

    public static final String LINE = "노선";

    public static final String RANGE = "구간";

    private final LineRepository lineRepository;

    private final InputView inputView;

    private final OutputView outputView;

    public LineController(InputView inputView, OutputView outputView) {
        this(new LineRepository(), inputView, outputView);
    }

    public LineController(LineRepository lineRepository, InputView inputView,
                          OutputView outputView) {
        this.lineRepository = lineRepository;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public LineController addLine() {
        String lineName = InputView.inputLineName();
        String startStation = InputView.inputStationName();
        String finalStation = InputView.inputStationName();

        LineRepository addedLineRepository =
                lineRepository.addLine(new Line(lineName, startStation, finalStation));

        OutputView.printSaved(LINE);

        return new LineController(addedLineRepository, this.inputView, this.outputView);
    }

    public LineController removeLine() {
        String lineName = InputView.inputLineName();

        LineRepository removedLineRepository = lineRepository.removeLine(lineName);

        OutputView.printRemoved(LINE);

        return new LineController(removedLineRepository, this.inputView, this.outputView);
    }

    public LineController loadLines() {
        OutputView.printLines(lineRepository);

        return this;
    }

    public LineController addRange() {
        String lineName = InputView.inputLineName();
        String stationName = InputView.inputStationName();
        int stationIndex = InputView.inputIndex();

        LineRepository rangeInsertedLineRepository =
                lineRepository.addRange(lineName, stationIndex, stationName);

        OutputView.printSaved(RANGE);

        return new LineController(rangeInsertedLineRepository, this.inputView, this.outputView);
    }

    public LineController removeRange() {
        String lineName = InputView.inputLineName();
        String stationName = InputView.inputStationName();

        LineRepository rangeRemovedLineRepository =
                lineRepository.removeRange(lineName, stationName);

        OutputView.printRemoved(RANGE);

        return new LineController(rangeRemovedLineRepository, this.inputView, this.outputView);
    }

    public LineController printSubwayMap() {
        OutputView.printSubwayMap(lineRepository);

        return this;
    }
}
