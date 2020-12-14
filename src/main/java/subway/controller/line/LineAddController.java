package subway.controller.line;

import subway.controller.Controller;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.StationRepository;
import subway.view.InfoMessage;
import subway.view.InputView;
import subway.view.OutputView;

public class LineAddController implements Controller {

    private final InputView inputView;

    public LineAddController(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public void run() {
        try {
            Line newLine = createLine();
            addStationsToLine(newLine);
            LineRepository.addLine(newLine);
            OutputView.printInfo(InfoMessage.LINE_ADDED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }

    private Line createLine() {
        String lineName = inputView.inputName(InputView.CHOOSE_LINE_ADD);
        return new Line(lineName);
    }

    private void addStationsToLine(Line newLine) {
        String beginningStationName = inputView.inputName(InputView.CHOOSE_LINE_STARTING);
        newLine.addStation(StationRepository.get(beginningStationName));

        String endingStationName = inputView.inputName(InputView.CHOOSE_LINE_FINISHING);
        newLine.addStation(StationRepository.get(endingStationName));
    }
}
