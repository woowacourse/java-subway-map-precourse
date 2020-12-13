package subway.controller;

import java.util.List;
import subway.domain.Station;

/**
 * @author yhh1056
 * @since 2020/12/12
 */
public class StationController {
    private final StationService stationService;

    public StationController() {
        this.stationService = new StationService();
    }

    public boolean createStation(final String name) {
        return stationService.addStation(name);
    }

    public boolean deleteStation(String name) {
        return stationService.deleteStation(name);
    }

    public List<Station> readStations() {
        return stationService.findAll();
    }
}
