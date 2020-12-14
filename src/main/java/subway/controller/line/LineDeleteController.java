package subway.controller.line;

import subway.controller.Controller;
import subway.domain.line.LineRepository;
import subway.view.ErrorMessage;
import subway.view.InfoMessage;
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
            String deletingLineName = inputView.inputName(InputView.CHOOSE_LINE_DELETE);
            deleteLine(deletingLineName);
            OutputView.printInfo(InfoMessage.LINE_DELETED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }

    private void deleteLine(String deletingLineName) {
        if (!LineRepository.deleteLineByName(deletingLineName)) {
            throw new IllegalArgumentException(ErrorMessage.LINE_NOTHING);
        }
    }
}
