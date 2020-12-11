package subway.station;

import subway.view.InputView;

public class StationController {
    private StationController() {
    }

    public static void register() {
        String name = InputView.getStationNameForRegistration();
        StationService.register(name);
    }
}
