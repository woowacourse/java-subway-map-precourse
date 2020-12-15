package subway.domain.service;

import subway.domain.Station;
import subway.domain.repository.StationRepository;
import utils.ScriptUtils;

public class StationService {
    private StationService() {}

    public static void createStation(String name) {
        Station station = new Station(name);
        StationRepository.addStation(station);
    }

    public static void readStationList() {
        System.out.println(ScriptUtils.STATION_LIST);
        for (Station station : StationRepository.stations()) {
            System.out.println(ScriptUtils.INFO + station.getName());
        }
    }

    public static void deleteStation(String name) {
        StationRepository.deleteStation(name);
    }
}
