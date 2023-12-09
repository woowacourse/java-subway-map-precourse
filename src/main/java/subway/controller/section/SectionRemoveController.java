package subway.controller.section;

import subway.view.InputView;
import subway.view.OutputView;

public class SectionRemoveController implements SubSectionController {
    private final InputView inputView;
    private final OutputView outputView;

    public SectionRemoveController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public SectionOption process() {
        return SectionOption.DELETE;
    }
}
