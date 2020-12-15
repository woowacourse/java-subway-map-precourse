package subway;

import subway.controller.MainController;
import subway.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        DefaultSetter.setupDefaultInfo();
        MainController.run();
    }
}

