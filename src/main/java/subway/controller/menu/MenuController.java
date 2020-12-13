package subway.controller.menu;

import java.util.ArrayList;
import java.util.List;
import subway.controller.Controller;
import subway.view.InputView;
import subway.view.OutputView;

public abstract class MenuController implements Controller {

    private static final int MIN_DECISION_VALUE = 1;
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
            decideNextController();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            run();
        }
    }

    protected void decideNextController() {
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
        validateDecision(decision, childControllers.size());
        childControllers.get(Integer.parseInt(decision) - 1).run();
    }

    protected void validateDecision(String decision, int maxDecisionValue) {
        validateNumeric(decision);
        validateRange(decision, maxDecisionValue);
    }

    private void validateNumeric(String decision) {
        try {
            Integer.parseInt(decision);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(OutputView.ERROR_NOT_NUMERIC);
        }
    }

    private void validateRange(String decision, int maxDecisionValue) {
        if (outOfRange(Integer.parseInt(decision), maxDecisionValue)) {
            throw new IllegalArgumentException(OutputView.ERROR_OUT_OF_RANGE);
        }
    }

    private boolean outOfRange(int decision, int maxDecisionValue) {
        return (decision > maxDecisionValue || decision < MIN_DECISION_VALUE);
    }
}
