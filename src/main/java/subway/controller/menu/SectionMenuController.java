package subway.controller.menu;

import subway.controller.Function;
import subway.controller.section.SectionAddController;
import subway.controller.section.SectionDeleteController;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionMenuController extends MenuController {

    public SectionMenuController(InputView inputView) {
        super(inputView);
        childControllers.add(new SectionAddController(inputView));
        childControllers.add(new SectionDeleteController(inputView));
    }

    @Override
    public void run() {
        try {
            String functionDecision = inputView.inputFunction(Function.SECTION_MENU);
            if (Function.isExitDecision(functionDecision, Function.SECTION_MENU)) {
                return;
            }
            Function.validate(functionDecision, Function.SECTION_MENU);
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
