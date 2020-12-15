package subway.controller;

import subway.view.InputView;

public class LineMapManager {

    private LineMapManager() {
    }

    public static void run(InputView inputView) {
        Initializer.set();
        Kiosk kiosk = new Kiosk(inputView);
        boolean ongoing;
        do {
            kiosk.scan();
            ongoing = kiosk.run();
            kiosk.orderClear();
        } while(ongoing);
    }
}
