package subway.controller.line;

import subway.controller.Controller;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class LineDeleteController implements Controller {

    private final InputView inputView;

    public LineDeleteController(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public void run() {
        try {
            String rawLineName = inputView.inputName(InputView.CHOOSE_DELETE_LINE);
            Line.validateName(rawLineName);
            LineRepository.deleteLineByName(rawLineName);

            OutputView.printInfo(OutputView.INFO_LINE_DELETE);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }
}
