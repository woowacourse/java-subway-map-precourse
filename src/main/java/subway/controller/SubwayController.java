package subway.controller;

import subway.service.subway.SubwayService;
import subway.service.initialization.LineInitialization;
import subway.service.initialization.StationInitialization;
import subway.service.initialization.TransitMapInitialization;

import java.util.Scanner;

public class SubwayController {
    public void runSubway(Scanner scanner) {
        initializeSubway();
        startSubway(scanner);
    }

    public static void initializeSubway() {
        StationInitialization.initializeStations();
        LineInitialization.initializeLines();
        TransitMapInitialization.initializeTransitMaps();
    }

    public static void startSubway(Scanner scanner) {
        SubwayService subwayService = new SubwayService();
        subwayService.manage(scanner);
    }
}
