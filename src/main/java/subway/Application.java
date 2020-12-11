package subway;

import subway.manager.MainManager;

public class Application {
    public static void main(String[] args) {
        Initialization.set();
        MainManager.execute();
    }
}
