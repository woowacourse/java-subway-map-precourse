package subway.controller.station;

import subway.domain.StationOption;
import subway.view.InputView;
import subway.view.OutputView;

public class StationRemoveController implements SubStationController {
    private final InputView inputView;
    private final OutputView outputView;

    public StationRemoveController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public StationOption process() {
        return StationOption.DELETE;
    }
}
