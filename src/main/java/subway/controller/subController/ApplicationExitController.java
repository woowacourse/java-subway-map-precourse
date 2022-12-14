package subway.controller.subController;

import subway.view.InputView;
import subway.view.OutputView;

public class ApplicationExitController implements Controllable {

    private final InputView inputView;
    private final OutputView outputView;

    public ApplicationExitController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {

    }
}
