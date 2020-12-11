package subway.controller;

import subway.service.StationService;

import java.util.Scanner;

public class StationController {
    public static void startStation(Scanner scanner) {
        StationService.manageStation(scanner);
    }
}
