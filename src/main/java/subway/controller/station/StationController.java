package subway.controller.station;

import static subway.util.Retry.retry;

import java.util.EnumMap;
import java.util.Map;
import subway.controller.SubController;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController implements SubController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Map<StationOption, SubController> subStationControllers = new EnumMap<>(StationOption.class);

    public StationController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        subStationControllers.put(StationOption.ADD, new StationAddController(inputView, outputView));
        subStationControllers.put(StationOption.DELETE, new StationRemoveController(inputView, outputView));
        subStationControllers.put(StationOption.LIST, new StationFindController(inputView, outputView));
    }

    @Override
    public void process() {
        while (true) {
            StationOption stationOption = retry(inputView::readStationOption);
            if (stationOption.isBack()) {
                break;
            }
            subStationControllers.get(stationOption).process();
        }
    }
}
