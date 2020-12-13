package subway.controller;

import java.util.ArrayList;
import java.util.List;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationManagementController {

    private static StationManagementController instance;


    private StationManagementController() {
    }

    public static StationManagementController getInstance() {
        if (instance == null) {
            instance = new StationManagementController();

        }
        return instance;
    }

    public void addStation(String name) {
        StationRepository.addStation(new Station(name));
    }

    public void deleteStation(String name) {

    }
}
