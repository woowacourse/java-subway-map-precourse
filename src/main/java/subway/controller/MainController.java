package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

public class MainController {

    public static final int MAIN_MENU = 0;

    private InputView inputView;

    public MainController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        try {
            String functionDecision = inputView.inputFunction();
            if(Function.isExitDecision(functionDecision)) {
                return;
            }
            Function.validate(functionDecision, MAIN_MENU);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            run();
        }
    }
}
