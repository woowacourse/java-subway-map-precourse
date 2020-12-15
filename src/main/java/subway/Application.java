package subway;

import subway.controller.MainController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        DefaultSetter.setupDefaultInfo();
        MainController.run();
    }
}

