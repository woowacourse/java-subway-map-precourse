package subway.controller.menu;

import java.util.ArrayList;
import java.util.List;
import subway.controller.Controller;
import subway.utils.MenuControllerValidator;
import subway.view.InputView;
import subway.view.OutputView;

public abstract class MenuController implements Controller {

    private static final String GO_BACK_DECISION = "B";

    protected final InputView inputView;
    protected final List<Controller> childControllers = new ArrayList<>();

    public MenuController(InputView inputView) {
        this.inputView = inputView;
    }

    protected abstract void printMenu();

    public void run() {
        try {
            printMenu();
            runNextDecidedController();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            run();
        }
    }

    protected void runNextDecidedController() {
        String decision = inputView.inputFunction();
        if (isExitDecision(decision)) {
            return;
        }
        runChildController(decision);
    }

    protected boolean isExitDecision(String decision) {
        return decision.equalsIgnoreCase(GO_BACK_DECISION);
    }

    protected void runChildController(String decision) {
        MenuControllerValidator.validateDecision(decision, childControllers.size());
        childControllers.get(Integer.parseInt(decision) - 1).run();
    }
}
