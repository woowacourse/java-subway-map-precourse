package subway.controller;

import subway.service.station.StationService;

import java.util.Scanner;

/**
 * StationController.java : 지하철 역에 대한 컨트롤러 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class StationController {
    public static void startStation(Scanner scanner) {
        StationService stationService = new StationService();
        stationService.manage(scanner);
    }
}
