package subway.controller.menu;

import subway.controller.Function;
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
    public void run() {
        try {
            String functionDecision = inputView.inputFunction(Function.STATION_MENU);
            if (Function.isExitDecision(functionDecision, Function.STATION_MENU)) {
                return;
            }
            Function.validate(functionDecision, Function.STATION_MENU);
            runChildController(functionDecision);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            run();
        }
    }

    protected void runChildController(String input) {
        int validInput = Integer.parseInt(input) - 1;
        childControllers.get(validInput).run();
    }
}
