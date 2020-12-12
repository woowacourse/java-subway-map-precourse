package subway;

import subway.view.MainScreen;

public class Application {

    public static void main(String[] args) {
        Load.initiate();
        MainScreen mainScreen = new MainScreen();
        mainScreen.start();
    }
}
