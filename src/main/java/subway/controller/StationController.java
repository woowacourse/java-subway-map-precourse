package subway.controller;

import subway.service.StationService;

public class StationController {

    public static void registerStation(String stationName) {
        try{
            StationService.registerStation(stationName);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
