package subway.controller.menu;

import subway.controller.map.MapController;
import subway.utils.MenuControllerValidator;
import subway.view.InputView;
import subway.view.OutputView;

public class MainMenuController extends MenuController {

    private static final String QUIT_DECISION = "Q";

    public static boolean isRunning = true;

    public MainMenuController(InputView inputView) {
        super(inputView);
        childControllers.add(new StationMenuController(inputView));
        childControllers.add(new LineMenuController(inputView));
        childControllers.add(new SectionMenuController(inputView));
        childControllers.add(new MapController());
    }

    @Override
    protected void printMenu() {
        OutputView.printMainMenu();
    }

    @Override
    protected void runNextDecidedController() {
        String decision = inputView.inputFunction();
        if (isExitDecision(decision)) {
            isRunning = false;
            return;
        }
        MenuControllerValidator.validateDecision(decision, childControllers.size());
        runChildController(decision);
    }

    @Override
    protected boolean isExitDecision(String decision) {
        return decision.equalsIgnoreCase(QUIT_DECISION);
    }
}
