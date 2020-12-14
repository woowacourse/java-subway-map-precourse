package subway.map;

import subway.controller.SubwayMapController;
import subway.domain.type.ManagementType;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayMapApplication {

    private final InputView inputView;
    private final SubwayMapController subwayMapController;

    public SubwayMapApplication(InputView inputView, SubwayMapController subwayMapController) {
        this.inputView = inputView;
        this.subwayMapController = subwayMapController;
    }

    public void run() {
        ManagementType managementType = ManagementType.initiate();
        while (managementType.isRunning()) {
            OutputView.printMainDisplay();
            managementType = inputView.inputManagementType();
        }
    }
}
