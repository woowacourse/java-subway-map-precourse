package subway.controller.line;

import subway.controller.Controller;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.StationRepository;
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
            OutputView.printInfo(OutputView.INFO_LINE_ADD);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }

    private Line createLine() {
        String lineName = inputView.inputName(InputView.CHOOSE_ADD_LINE);
        Line.validateName(lineName);
        return new Line(lineName);
    }

    private void addStationsToLine(Line newLine) {
        newLine.add(StationRepository.get(inputView.inputName(InputView.CHOOSE_LINE_BEGINNING)));
        newLine.add(StationRepository.get(inputView.inputName(InputView.CHOOSE_LINE_ENDING)));
    }
}
