package subway.controller.station;

import subway.domain.StationOption;
import subway.view.InputView;
import subway.view.OutputView;

public class StationFindController implements SubStationController {
    private final InputView inputView;
    private final OutputView outputView;

    public StationFindController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public StationOption process() {
        return StationOption.LIST;
    }
}
