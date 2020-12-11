package subway.controller;

import subway.service.LineService;
import subway.service.StationService;
import subway.view.OutputView;

public class SubwayController {
    public static void runSubway() {
        initializeSubway();
        OutputView.printMainScreen();
    }

    public static void initializeSubway() {
        StationService.initializeStations();
        LineService.initializeLines();
    }
}
