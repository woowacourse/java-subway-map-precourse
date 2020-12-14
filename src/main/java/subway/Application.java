package subway;

import subway.controller.MainController;

public class Application {
    public static void main(String[] args) {
        InitialSetting.setInitialSubwayInfo();
        MainController.goToMain();
    }
}
