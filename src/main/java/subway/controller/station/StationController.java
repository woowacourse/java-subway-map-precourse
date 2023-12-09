package subway.controller.station;

import java.util.EnumMap;
import java.util.Map;
import subway.controller.SubController;
import subway.domain.MainOption;
import subway.domain.StationOption;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController implements SubController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Map<StationOption, SubStationController> subStationControllers = new EnumMap<>(StationOption.class);

    public StationController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        subStationControllers.put(StationOption.ADD, new StationAddController(inputView, outputView));
        subStationControllers.put(StationOption.DELETE, new StationRemoveController(inputView, outputView));
        subStationControllers.put(StationOption.LIST, new StationFindController(inputView, outputView));
        subStationControllers.put(StationOption.BACK, new StationBackController());
    }

    @Override
    public MainOption process() {
        while (true) {
            StationOption stationOption = inputView.readStationOption();
            SubStationController subStationController = subStationControllers.get(stationOption);
            if (subStationController.process().isBack()) {
                break;
            }
        }
        return MainOption.STATION;
    }
}
