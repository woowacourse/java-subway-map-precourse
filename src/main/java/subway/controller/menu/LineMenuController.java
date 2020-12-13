package subway.controller.menu;

import subway.controller.Function;
import subway.controller.line.LineAddController;
import subway.controller.line.LineDeleteController;
import subway.controller.line.LineViewController;
import subway.view.InputView;
import subway.view.OutputView;

public class LineMenuController extends MenuController {

    public LineMenuController(InputView inputView) {
        super(inputView);
        childControllers.add(new LineAddController(inputView));
        childControllers.add(new LineDeleteController(inputView));
        childControllers.add(new LineViewController());
    }

    @Override
    public void run() {
        try {
            String functionDecision = inputView.inputFunction(Function.LINE_MENU);
            if (Function.isExitDecision(functionDecision, Function.LINE_MENU)) {
                return;
            }
            Function.validate(functionDecision, Function.LINE_MENU);
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
