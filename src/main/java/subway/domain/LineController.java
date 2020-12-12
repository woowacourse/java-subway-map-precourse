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

    public void removeLine() {
        String lineName = inputView.inputLineName();

        lineRepository.removeLine(lineName);

        outputView.printStationRemoved();
    }

    public void loadLines() {
        outputView.printLines(lineRepository);
    }

    public void insertStation() {
        String lineName = inputView.inputLineName();
        String stationName = inputView.inputStationName();
        int stationIndex = inputView.inputIndex();

        lineRepository.insertStation(lineName, stationIndex, stationName);

        outputView.printRangeSaved();
    }

    public void removeStation() {
        String lineName = inputView.inputLineName();
        String stationName = inputView.inputStationName();

        lineRepository.removeStation(lineName, stationName);

        outputView.printRangeRemoved();
    }
}
