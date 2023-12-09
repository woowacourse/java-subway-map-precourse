package subway.controller;

import subway.domain.MainOption;
import subway.view.InputView;
import subway.view.OutputView;

public class QuitController implements SubController {
    private final InputView inputView;
    private final OutputView outputView;

    public QuitController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public MainOption process() {
        return MainOption.QUIT;
    }
}
