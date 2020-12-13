package subway.common;

import subway.view.InputView;
import subway.view.OutputView;

import static subway.view.resource.Strings.SELECT_ACTIVITY;

public class MainController {
    private MainController() {
    }

    public static void execute() {
        try {
            OutputView.printGuide(SELECT_ACTIVITY);
            String command = InputView.getFunction();
            Runnable function = MainFunctionMapper.matchFunction(command);
            function.run();
        } catch (RuntimeException exception) {
            OutputView.printError(exception.getMessage());
        }
    }
}
