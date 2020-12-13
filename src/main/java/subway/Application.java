package subway;

import subway.common.MainController;
import subway.common.domain.Status;

public class Application {
    public static void main(String[] args) {
        operateSubwaySystem();
    }

    private static void operateSubwaySystem() {
        do {
            MainController.execute();
        } while (Status.isContinue());
    }
}
