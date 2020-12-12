package subway.controller;

import java.util.ArrayList;
import java.util.List;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController extends Controller {

    public static boolean isRunning = true;

    private final List<Controller> controllers = new ArrayList<>();

    public MainController(InputView inputView) {
        super(inputView);
        controllers.add(new StationController(inputView));
        controllers.add(new LineController(inputView));
        controllers.add(new SectionController(inputView));
        controllers.add(new MapController(inputView));
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
            goTo(controllers.get(Integer.parseInt(functionDecision) - 1));
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            run();
        }
    }

    private void goTo(Controller controller) {
        controller.run();
    }
}
