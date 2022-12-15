package subway.controller.subController;

import subway.controller.subController.Controllable;
import subway.domain.option.StationOption;
import subway.view.InputView;
import subway.view.OutputView;

public class StationManagementController implements Controllable {

    private final InputView inputView;
    private final OutputView outputView;

    public StationManagementController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }



    @Override
    public void process() {
        outputView.printStationOption();
        StationOption stationOption = inputView.readStationOption();
        System.out.println(stationOption);
    }
}
