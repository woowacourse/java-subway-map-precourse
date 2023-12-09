package subway.controller.line;

import subway.view.OutputView;

public class LineFindController implements SubLineController {
    private final OutputView outputView;

    public LineFindController(OutputView outputView) {
        this.outputView = outputView;
    }

    @Override
    public LineOption process() {
        return LineOption.LIST;
    }
}
