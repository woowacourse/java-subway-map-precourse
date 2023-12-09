package subway.controller.line;

import subway.view.InputView;
import subway.view.OutputView;

public class LineRemoveController implements SubLineController {
    private final InputView inputView;
    private final OutputView outputView;

    public LineRemoveController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public LineOption process() {
        return LineOption.DELETE;
    }
}
