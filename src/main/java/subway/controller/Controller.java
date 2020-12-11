package subway.controller;

import subway.view.InputView;

public class Controller {
    protected InputView inputView;

    public Controller(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {}
}
