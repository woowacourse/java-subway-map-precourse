package subway.controller.menu;

import subway.controller.station.StationAddController;
import subway.controller.station.StationDeleteController;
import subway.controller.station.StationViewController;
import subway.view.InputView;
import subway.view.OutputView;

public class StationMenuController extends MenuController {

    public StationMenuController(InputView inputView) {
        super(inputView);
        childControllers.add(new StationAddController(inputView));
        childControllers.add(new StationDeleteController(inputView));
        childControllers.add(new StationViewController());
    }

    @Override
    protected void printMenu() {
        OutputView.printStationMenu();
    }
}
