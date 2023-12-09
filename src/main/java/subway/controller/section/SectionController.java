package subway.controller.section;

import subway.controller.SubController;
import subway.domain.MainOption;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionController implements SubController {
    private final InputView inputView;
    private final OutputView outputView;

    public SectionController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public MainOption process() {
        return MainOption.SECTION;
    }
}
