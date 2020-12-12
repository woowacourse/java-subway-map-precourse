package subway.domain;

import subway.view.InputView;
import subway.view.OutputView;

public class LineController {

    private final LineRepository lineRepository;

    private final InputView inputView;

    private final OutputView outputView;

    public LineController() {
        this.lineRepository = new LineRepository();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void addLine() {
        String lineName = inputView.inputLineName();
        String startStation = inputView.inputStationName();
        String finalStation = inputView.inputStationName();

        lineRepository.addLine(new Line(lineName, startStation, finalStation));

        outputView.printLineSaved();
    }
}
