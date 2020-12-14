package subway.controller.line;

import subway.controller.Controller;
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
            String lineName = inputView.inputName(InputView.CHOOSE_DELETE_LINE);
            if (!LineRepository.deleteLineByName(lineName)) {
                throw new IllegalArgumentException(OutputView.ERROR_NO_LINE);
            }
            OutputView.printInfo(OutputView.INFO_LINE_DELETED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }
}
