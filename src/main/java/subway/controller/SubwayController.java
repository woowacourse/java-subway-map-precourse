package subway.controller;

import subway.service.LineService;
import subway.service.StationService;
import subway.service.SubwayService;

import java.util.Scanner;

public class SubwayController {
    public void runSubway(Scanner scanner) {
        initializeSubway();
        startSubway(scanner);
    }

    public static void initializeSubway() {
        StationService.initializeStations();
        LineService.initializeLines();
    }

    public static void startSubway(Scanner scanner) {
        SubwayService.manageSubway(scanner);
    }
}
