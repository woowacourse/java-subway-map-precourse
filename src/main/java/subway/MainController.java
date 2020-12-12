package subway;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.resource.CommonMessage;

public class MainController {
    private MainController() {
    }

    public static void execute() {
        OutputView.printGuideMessage(CommonMessage.SELECT_ACTIVITY);
        String command = InputView.getFunction();
        Runnable function = MainFunctionMapper.matchFunction(command);
        function.run();
    }
}
