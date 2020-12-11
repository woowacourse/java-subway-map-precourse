package subway.controller;

import subway.view.InputView;

public class MainController {

    private InputView inputView;

    public MainController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String functionNumber = inputView.inputFunction();
    }
}
