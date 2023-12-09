package subway.controller.map;

import subway.controller.SubController;
import subway.controller.MainOption;
import subway.view.InputView;
import subway.view.OutputView;

public class MapController implements SubController {
    private final InputView inputView;
    private final OutputView outputView;

    public MapController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public MainOption process() {
        return MainOption.MAP;
    }
}
