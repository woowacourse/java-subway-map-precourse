package subway;

import subway.controller.MainMenu;

public class Application {
    public static void main(String[] args) {
        InitialSetting.setInitialSubwayInfo();
        MainMenu.goToMain();
    }
}
