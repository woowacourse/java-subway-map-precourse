package subway;

import subway.initialize.Initialization;
import subway.manager.MainManager;
import utils.Power;

public class Application {
    public static void main(String[] args) {
        Power.on();
        Initialization.set();
        MainManager.execute();
    }
}
