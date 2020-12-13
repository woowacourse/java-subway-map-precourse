package subway;

import subway.common.MainController;

public class Application {
    public static void main(String[] args) {
        operateSubwaySystem();
    }

    private static void operateSubwaySystem() {
        MainController.execute();
    }
}
