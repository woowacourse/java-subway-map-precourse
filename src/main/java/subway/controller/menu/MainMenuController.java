package subway.controller.menu;

import subway.controller.Function;
import subway.controller.map.MapController;
import subway.view.InputView;
import subway.view.OutputView;

public class MainMenuController extends MenuController {

    public static boolean isRunning = true;

    public MainMenuController(InputView inputView) {
        super(inputView);
        childControllers.add(new StationMenuController(inputView));
        childControllers.add(new LineMenuController(inputView));
        childControllers.add(new SectionMenuController(inputView));
        childControllers.add(new MapController());
    }

    @Override
    public void run() {
        try {
            String functionDecision = inputView.inputFunction(Function.MAIN_MENU);
            if (Function.isExitDecision(functionDecision, Function.MAIN_MENU)) {
                isRunning = false;
                return;
            }
            Function.validate(functionDecision, Function.MAIN_MENU);
            runChildController(functionDecision);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            run();
        }
    }

    @Override
    protected void runChildController(String input) {
        int validInput = Integer.parseInt(input) - 1;
        childControllers.get(validInput).run();
    }
}
