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
            addNewLine();
            OutputView.printInfo(InfoMessage.LINE_ADDED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }

    private void addNewLine() {
        Line newLine = createLine();
        addStationsToLine(newLine);
        LineRepository.addLine(newLine);
    }

    private Line createLine() {
        String lineName = inputView.inputName(InputView.CHOOSE_LINE_ADD);
        return new Line(lineName);
    }

    private void addStationsToLine(Line newLine) {
        addStartingStation(newLine);
        addFinishingStation(newLine);
    }

    private void addStartingStation(Line newLine) {
        String startingStationName = inputView.inputName(InputView.CHOOSE_LINE_STARTING);
        newLine.addStation(StationRepository.get(startingStationName));
    }

    private void addFinishingStation(Line newLine) {
        String finishingStationName = inputView.inputName(InputView.CHOOSE_LINE_FINISHING);
        newLine.addStation(StationRepository.get(finishingStationName));
    }
}
